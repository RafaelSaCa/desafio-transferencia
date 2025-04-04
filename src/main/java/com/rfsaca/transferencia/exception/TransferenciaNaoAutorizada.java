package com.rfsaca.transferencia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class TransferenciaNaoAutorizada extends AppException{

        @Override
        public ProblemDetail toProblemDetail() {
                var problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

                problemDetail.setTitle("Transferência não autorizada!");
                problemDetail.setDetail("O serviço de autorização não permitiu essa transferência.");

                return problemDetail;
        }

}
