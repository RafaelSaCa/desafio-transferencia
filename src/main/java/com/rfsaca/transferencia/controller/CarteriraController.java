package com.rfsaca.transferencia.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rfsaca.transferencia.controller.dto.CarteiraDTO;
import com.rfsaca.transferencia.model.Carteira;
import com.rfsaca.transferencia.service.CarteiraService;

import jakarta.validation.Valid;

@RestController
public class CarteriraController {

        private final CarteiraService carteiraService;

        public CarteriraController(CarteiraService carteiraService) {
                this.carteiraService = carteiraService;
        }

        
        @PostMapping("/carteiras")
        public ResponseEntity<Carteira> novaCarteira (@RequestBody @Valid CarteiraDTO carteiraDTO){
                Carteira carteira = carteiraService.create(carteiraDTO);

                return ResponseEntity.ok(carteira);
        }
       
}
