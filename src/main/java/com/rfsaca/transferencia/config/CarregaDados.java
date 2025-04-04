package com.rfsaca.transferencia.config;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rfsaca.transferencia.model.TipoCarteira;
import com.rfsaca.transferencia.repository.TipoCarteiraRepository;

@Configuration
public class CarregaDados implements CommandLineRunner {

        private final TipoCarteiraRepository tipoCarteiraRepository;

        public CarregaDados(TipoCarteiraRepository tipoCarteiraRepository) {
                this.tipoCarteiraRepository = tipoCarteiraRepository;
        }

        @Override
        public void run(String... args) throws Exception {
                Arrays.stream(TipoCarteira.Enum.values())
                                .map(TipoCarteira.Enum::get)
                                .forEach(tipoCarteira -> {
                                        Optional<TipoCarteira> existente = tipoCarteiraRepository
                                                        .findById(tipoCarteira.getId());
                                        if (existente.isPresent()) {
                                                tipoCarteiraRepository.save(tipoCarteira); // Atualiza
                                        } else {
                                                tipoCarteira.setId(null); // Define ID como null para criar um novo
                                                                          // registro
                                                tipoCarteiraRepository.save(tipoCarteira); // Cria novo
                                        }
                                });
        }

}
