package com.rfsaca.transferencia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rfsaca.transferencia.model.Carteira;

public interface CarteiraRepository extends JpaRepository<Carteira, Long>{

        Optional<Carteira> findByCpfCnpjOrEmail(String cpfCnpj, String email);


}
