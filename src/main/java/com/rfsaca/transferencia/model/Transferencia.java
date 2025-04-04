package com.rfsaca.transferencia.model;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_transferencia")
public class Transferencia {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;

        @ManyToOne
        @JoinColumn(name = "carteira_pagador_id")
        private Carteira pagador;

        @ManyToOne
        @JoinColumn(name = "carteira_recebedor_id")
        private Carteira recebedor;

        @Column(name = "valor")
        private BigDecimal valor;

        public Transferencia() {
        }

        public Transferencia(Carteira pagador, Carteira recebedor, BigDecimal valor) {
                this.pagador = pagador;
                this.recebedor = recebedor;
                this.valor = valor;
        }

        public UUID getId() {
                return id;
        }

        public void setId(UUID id) {
                this.id = id;
        }

        public Carteira getPagador() {
                return pagador;
        }

        public void setPagador(Carteira pagador) {
                this.pagador = pagador;
        }

        public Carteira getRecebedor() {
                return recebedor;
        }

        public void setRecebedor(Carteira recebedor) {
                this.recebedor = recebedor;
        }

        public BigDecimal getValor() {
                return valor;
        }

        public void setValor(BigDecimal valor) {
                this.valor = valor;
        }

}
