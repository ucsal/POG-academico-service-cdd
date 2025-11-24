package com.ucsal.disciplina_microsservice.controller.dto.response;

import lombok.Data;

@Data
public class CursoResponseDTO {
    private Long id;
    private String nome;
    private Long escolaId;
    private String matrizesIds;
}
