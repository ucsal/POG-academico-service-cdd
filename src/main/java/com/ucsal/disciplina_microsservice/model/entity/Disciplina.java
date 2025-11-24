package com.ucsal.disciplina_microsservice.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "disciplinas")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sigla;
    private String descricao;
    private int cargaHoraria;
    private String tipo;
    private String classificacao;
    private boolean ativa = true;

    @Column(name = "matrizes_ids")
    private String matrizesIds;

    @Column(name = "prerequisitos_ids")
    private String prerequisitosIds;

    @Column(name = "programa_id")
    private Long programaId;
}

