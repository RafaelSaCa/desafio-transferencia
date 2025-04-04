package com.rfsaca.transferencia.controller.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public record TransferenciaDTO(@DecimalMin("0.01") @NotNull BigDecimal valor,
                                                     @NotNull Long pagador,
                                                     @NotNull Long recebedor) {

}
