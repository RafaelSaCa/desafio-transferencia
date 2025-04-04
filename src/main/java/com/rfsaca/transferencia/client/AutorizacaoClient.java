package com.rfsaca.transferencia.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.rfsaca.transferencia.client.dto.AutorizacaoResposta;

@FeignClient(name = "autorizacao",url="${client.authorization-service.url}")
public interface AutorizacaoClient {

        @GetMapping
        ResponseEntity<AutorizacaoResposta>autorizado();
}
