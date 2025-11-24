package com.ucsal.disciplina_microsservice.controller.dto.request;

import lombok.Data;

@Data
public class EscolaRequestDTO {
    private String nome;
    private String professoresIds;
    private String cursosIds;
}
