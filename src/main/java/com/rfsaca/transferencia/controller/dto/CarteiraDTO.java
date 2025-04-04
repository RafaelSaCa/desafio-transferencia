package com.rfsaca.transferencia.controller.dto;

import com.rfsaca.transferencia.model.Carteira;
import com.rfsaca.transferencia.model.TipoCarteira;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CarteiraDTO(@NotBlank String nomeCompleto,
                                           @NotBlank String cpfCnpj,
                                           @NotBlank String email,
                                           @NotBlank String senha,
                                           @NotNull TipoCarteira.Enum tipoCarteira) {
        
        //MÉTODO PARA CONVERTER DTO PARA A ENTIDADE
        public Carteira toCarteira(){
                return new Carteira(
                                nomeCompleto,
                                cpfCnpj,
                                email,
                                senha,
                                tipoCarteira.get()
                );
        }
}
