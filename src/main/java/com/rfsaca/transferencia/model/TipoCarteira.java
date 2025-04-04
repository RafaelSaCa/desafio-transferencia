package com.rfsaca.transferencia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tipo_carteira")
public class TipoCarteira {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String descricao;

        public TipoCarteira() {
        }

        public TipoCarteira(Long id, String descricao) {
                this.id = id;
                this.descricao = descricao;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getDescricao() {
                return descricao;
        }

        public void setDescricao(String descricao) {
                this.descricao = descricao;
        }

        public enum Enum {

                USER(1L, "user"),
                LOJISTA(2L, "lojista");

                Enum(Long id, String descricao) {
                        this.id = id;
                        this.descricao = descricao;
                }

                private Long id;
                private String descricao;

                public TipoCarteira get() {
                        return new TipoCarteira(id, descricao);
                }
        }

        //metodos para verificar se o tipo da carteira permite transferencia
        @Override
        public int hashCode() {
                final int prime = 31;
                int result = 1;
                result = prime * result + ((id == null) ? 0 : id.hashCode());
                result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
                return result;
        }

        @Override
        public boolean equals(Object obj) {
                if (this == obj)
                        return true;
                if (obj == null)
                        return false;
                if (getClass() != obj.getClass())
                        return false;
                TipoCarteira other = (TipoCarteira) obj;
                if (id == null) {
                        if (other.id != null)
                                return false;
                } else if (!id.equals(other.id))
                        return false;
                if (descricao == null) {
                        if (other.descricao != null)
                                return false;
                } else if (!descricao.equals(other.descricao))
                        return false;
                return true;
        }

        

}
