package com.rfsaca.transferencia.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rfsaca.transferencia.model.Transferencia;

@FeignClient(name="notificacao",url="${client.notification-service.url}")
public interface NotificacaoClient {

        @PostMapping
        ResponseEntity<Void> enviaNotificacao (@RequestBody Transferencia transferencia);
}