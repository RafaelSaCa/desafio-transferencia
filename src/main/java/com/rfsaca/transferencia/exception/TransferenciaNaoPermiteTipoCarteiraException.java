package com.rfsaca.transferencia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class TransferenciaNaoPermiteTipoCarteiraException extends AppException {

        @Override
        public ProblemDetail toProblemDetail() {
                
                var problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

                problemDetail.setTitle("O tipo da carteira não permite transferência! ");

                return problemDetail;
        }

}
