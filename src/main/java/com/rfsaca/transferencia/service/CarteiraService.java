package com.rfsaca.transferencia.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rfsaca.transferencia.controller.dto.CarteiraDTO;
import com.rfsaca.transferencia.exception.CarteiraExistenteException;
import com.rfsaca.transferencia.model.Carteira;
import com.rfsaca.transferencia.repository.CarteiraRepository;

@Service
public class CarteiraService {

        private final CarteiraRepository repository;

        public CarteiraService(CarteiraRepository repository) {
                this.repository = repository;
        }

        public Carteira create(CarteiraDTO carteiraDTO) {

                Optional<Carteira> carteiraExistente = repository.findByCpfCnpjOrEmail(carteiraDTO.cpfCnpj(),
                                carteiraDTO.email());

                if (carteiraExistente.isPresent()) {
                        throw new CarteiraExistenteException("O CPF/CNPJ ou e-mail já cadastrado! ");
                }

                return repository.save(carteiraDTO.toCarteira());
        }

}
