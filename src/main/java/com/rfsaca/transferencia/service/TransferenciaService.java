package com.rfsaca.transferencia.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import com.rfsaca.transferencia.controller.dto.TransferenciaDTO;
import com.rfsaca.transferencia.exception.CarteiraNaoEncontradaException;
import com.rfsaca.transferencia.exception.SaldoInsuficienteException;
import com.rfsaca.transferencia.exception.TransferenciaNaoAutorizada;
import com.rfsaca.transferencia.exception.TransferenciaNaoPermiteTipoCarteiraException;
import com.rfsaca.transferencia.model.Carteira;
import com.rfsaca.transferencia.model.Transferencia;
import com.rfsaca.transferencia.repository.CarteiraRepository;
import com.rfsaca.transferencia.repository.TransferenciaRepository;

import jakarta.transaction.Transactional;

@Service
public class TransferenciaService {

        private final TransferenciaRepository transferenciaRepository;
        private final CarteiraRepository carteiraRepository;
        private final AutorizacaoService autorizacaoService;
        private final NotificacaoService notificacaoService;

        public TransferenciaService(TransferenciaRepository transferenciaRepository,
                        CarteiraRepository carteiraRepository,
                        AutorizacaoService autorizacaoService,
                        NotificacaoService notificacaoService) {
                this.transferenciaRepository = transferenciaRepository;
                this.carteiraRepository = carteiraRepository;
                this.autorizacaoService = autorizacaoService;
                this.notificacaoService = notificacaoService;
        }

        @Transactional
        public Transferencia transferir(TransferenciaDTO transferenciaDTO) {
                var pagador = carteiraRepository.findById(transferenciaDTO.pagador())
                                .orElseThrow(() -> new CarteiraNaoEncontradaException(transferenciaDTO.pagador()));

                var recebedor = carteiraRepository.findById(transferenciaDTO.recebedor())
                                .orElseThrow(() -> new CarteiraNaoEncontradaException(transferenciaDTO.recebedor()));

                validaTransferencia(transferenciaDTO, pagador);

                pagador.debito(transferenciaDTO.valor());
                recebedor.credito(transferenciaDTO.valor());

                var transferencia = new Transferencia(pagador, recebedor, transferenciaDTO.valor());

                carteiraRepository.save(pagador);
                carteiraRepository.save(recebedor);
                var transferenciaSalva = transferenciaRepository.save(transferencia);

                // envio da mensagem de forma assíncrona (caso aconteça algo errado, não afeta a
                // transferencia)
                CompletableFuture.runAsync(() -> notificacaoService.enviaNotificacao(transferenciaSalva));

                return transferenciaSalva;

        }

        private void validaTransferencia(TransferenciaDTO transferenciaDTO, Carteira pagador) {
                if (!pagador.tipoCarteriraPermiteTransferencia()) {
                        throw new TransferenciaNaoPermiteTipoCarteiraException();
                }

                if (!pagador.saldoSuficiente(transferenciaDTO.valor())) {
                        throw new SaldoInsuficienteException();
                }

                if (autorizacaoService.autorizado(transferenciaDTO)) {
                        throw new TransferenciaNaoAutorizada();
                }
        }

}
