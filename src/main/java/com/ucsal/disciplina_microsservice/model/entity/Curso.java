package com.ucsal.disciplina_microsservice.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name = "escola_id")
    private Long escolaId;

    @Column(name = "matrizes_ids")
    private String matrizesIds;

    public Curso(String nome, Long escolaId) {
        this.nome = nome;
        this.escolaId = escolaId;
    }
}
