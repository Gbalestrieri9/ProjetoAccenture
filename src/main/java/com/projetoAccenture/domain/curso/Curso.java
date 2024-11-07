package com.projetoAccenture.domain.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @PrePersist
    protected void data() {
        this.dataCriacao = new Date();
    }
}
