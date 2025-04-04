package com.rfsaca.transferencia.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rfsaca.transferencia.controller.dto.TransferenciaDTO;
import com.rfsaca.transferencia.model.Transferencia;
import com.rfsaca.transferencia.service.TransferenciaService;

import jakarta.validation.Valid;

@RestController
public class TransferenciaController {

        private final TransferenciaService service;

        public TransferenciaController(TransferenciaService service) {
                this.service = service;
        }

        @PostMapping("/transferir")
        public ResponseEntity<Transferencia> transferencia (@RequestBody @Valid TransferenciaDTO transferenciaDTO){

                 Transferencia transferencia = service.transferir(transferenciaDTO);

                return ResponseEntity.ok(transferencia);
        }

}
