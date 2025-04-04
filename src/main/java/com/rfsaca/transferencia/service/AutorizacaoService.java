package com.rfsaca.transferencia.service;

import org.springframework.stereotype.Service;

import com.rfsaca.transferencia.client.AutorizacaoClient;
import com.rfsaca.transferencia.controller.dto.TransferenciaDTO;
import com.rfsaca.transferencia.exception.AppException;

@Service
public class AutorizacaoService {
        private final AutorizacaoClient autorizacaoClient;

        public AutorizacaoService(AutorizacaoClient autorizacaoClient) {
                this.autorizacaoClient = autorizacaoClient;
        }

        public boolean autorizado(TransferenciaDTO transferenciaDTO) {
                var resposta = autorizacaoClient.autorizado();

                if (resposta.getStatusCode().isError()) {
                        throw new AppException();
                }

                return resposta.getBody().autorizado();
        }

}
