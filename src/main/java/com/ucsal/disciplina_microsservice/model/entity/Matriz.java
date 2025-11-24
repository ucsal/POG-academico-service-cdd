package com.ucsal.disciplina_microsservice.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "matrizes")
public class Matriz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String turnoPadrao;
    private String campus;
    private String habilitacao;

    private int horasAtividadesComplementares;
    private int horasDisciplinasObrigatorias;
    private int horasDisciplinasExtras;
    private int horasTCC;

    @Column(name = "curso_id")
    private Long cursoId;

    @Column(name = "disciplinas_ids")
    private String disciplinasIds;
}
