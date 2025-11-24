package com.ucsal.disciplina_microsservice.controller.dto.request;

import lombok.Data;

@Data
public class CursoRequestDTO {
    private String nome;
    private Long escolaId;
    private String matrizesIds;
}
