package com.rfsaca.transferencia.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_carteira")
public class Carteira {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "nome_completo")
        private String nomeCompleto;

        @Column(name = "cpf_cnpj", unique = true)
        private String cpfCnpj;

        @Column(name = "email", unique = true)
        private String email;

        @Column(name = "senha")
        private String senha;

        @Column(name = "saldo")
        private BigDecimal saldo = BigDecimal.ZERO;

        @ManyToOne
        @JoinColumn(name = "tipoCarteira_id")
        private TipoCarteira tipoCarteira;

        public Carteira() {
        }

        // CONSTRUTOR SOMENTE COM AS PROPRIEDADES NECESSARIAS
        public Carteira(String nomeCompleto, String cpfCnpj, String email, String senha, TipoCarteira tipoCarteira) {
                this.nomeCompleto = nomeCompleto;
                this.cpfCnpj = cpfCnpj;
                this.email = email;
                this.senha = senha;
                this.tipoCarteira = tipoCarteira;
        }

        // verifica se o enum é usuario para permitir transferencia
        public boolean tipoCarteriraPermiteTransferencia() {
                return this.tipoCarteira.equals(TipoCarteira.Enum.USER.get());
        }

        public boolean saldoSuficiente(BigDecimal valor) {
                return this.saldo.doubleValue() >= valor.doubleValue();

        }
        
        public void credito(BigDecimal valor) {
              this.saldo = this.saldo.add(valor);
        }

        public void debito(BigDecimal valor) {
               this.saldo = this.saldo.subtract(valor);
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getNomeCompleto() {
                return nomeCompleto;
        }

        public void setNomeCompleto(String nomeCompleto) {
                this.nomeCompleto = nomeCompleto;
        }

        public String getCpfCnpj() {
                return cpfCnpj;
        }

        public void setCpfCnpj(String cpfCnpj) {
                this.cpfCnpj = cpfCnpj;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getSenha() {
                return senha;
        }

        public void setSenha(String senha) {
                this.senha = senha;
        }

        public BigDecimal getSaldo() {
                return saldo;
        }

        public void setSaldo(BigDecimal saldo) {
                this.saldo = saldo;
        }

        public TipoCarteira getTipoCarteira() {
                return tipoCarteira;
        }

        public void setTipoCarteira(TipoCarteira tipoCarteira) {
                this.tipoCarteira = tipoCarteira;
        }



}
