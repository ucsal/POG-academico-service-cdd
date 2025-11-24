package com.ucsal.disciplina_microsservice.controller.dto.response;

import lombok.Data;

@Data
public class MatrizResponseDTO {

    private Long id;

    private String nome;
    private String turnoPadrao;
    private String campus;
    private String habilitacao;

    private int horasAtividadesComplementares;
    private int horasDisciplinasObrigatorias;
    private int horasDisciplinasExtras;
    private int horasTCC;

    private Long cursoId;
    private String disciplinasIds;
}
