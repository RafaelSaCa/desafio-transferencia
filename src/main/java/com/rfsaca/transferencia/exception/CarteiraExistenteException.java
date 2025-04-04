package com.rfsaca.transferencia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class CarteiraExistenteException extends AppException {

        private String detail;

        public CarteiraExistenteException(String detail) {
                this.detail = detail;
        }

        @Override
        public ProblemDetail toProblemDetail() {

                var problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

                problemDetail.setTitle("A Carteria já existe na base de dados!");
                problemDetail.setDetail(detail);
                
                return problemDetail;
        }

}
