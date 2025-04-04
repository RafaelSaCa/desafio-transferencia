package com.rfsaca.transferencia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class SaldoInsuficienteException extends AppException{

        @Override
        public ProblemDetail toProblemDetail() {
               var problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

               problemDetail.setTitle("Saldo Insuficiente!");
               problemDetail.setDetail("Você não pode enviar um valor maior que o saldo disponível.");

               return problemDetail;
               
        }

}
