package com.ucsal.disciplina_microsservice.controller.dto.response;

import lombok.Data;

@Data
public class EscolaResponseDTO {
    private Long id;
    private String nome;
    private String professoresIds;
    private String cursosIds;
}

