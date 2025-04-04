package com.rfsaca.transferencia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class CarteiraNaoEncontradaException extends AppException {

        private Long carteiraId;

        public CarteiraNaoEncontradaException(Long carteiraId) {
                this.carteiraId = carteiraId;
        }

        @Override
        public ProblemDetail toProblemDetail() {
                var problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

                problemDetail.setTitle("Carteira não encontrada!");
                problemDetail.setDetail("Não existe nenhuma carteira com o id" + carteiraId + ".");

                return problemDetail;
        }

}
