package com.ucsal.disciplina_microsservice.model.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Escola {

    private Long id;

    private String nome;
    private String sigla;
    private boolean ativo = true;
}
