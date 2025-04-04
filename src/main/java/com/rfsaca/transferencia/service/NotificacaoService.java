package com.rfsaca.transferencia.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rfsaca.transferencia.client.NotificacaoClient;
import com.rfsaca.transferencia.model.Transferencia;

@Service
public class NotificacaoService {

        // log de erro para enviar a notificação
        private final Logger logger = LoggerFactory.getLogger(NotificacaoService.class);

        private final NotificacaoClient notificacaoClient;

        public NotificacaoService(NotificacaoClient notificacaoClient) {
                this.notificacaoClient = notificacaoClient;
        }

        public void enviaNotificacao(Transferencia transferencia) {

                try {
                        logger.info("Enviando notificação!");
                        var resposta = notificacaoClient.enviaNotificacao(transferencia);

                        if (resposta.getStatusCode().isError()) {
                                logger.error("Erro ao enviar a notifcação");
                        }

                } catch (Exception e) {
                        logger.error("Erro ao enviar a notifcação", e);

                }
        }

}
