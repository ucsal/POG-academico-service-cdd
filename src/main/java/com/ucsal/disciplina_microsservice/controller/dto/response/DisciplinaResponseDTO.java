package com.ucsal.disciplina_microsservice.controller.dto.response;

import lombok.Data;

@Data
public class DisciplinaResponseDTO {
    private Long id;
    private String sigla;
    private String descricao;
    private int cargaHoraria;
    private String tipo;
    private String classificacao;
    private boolean ativa;
    private String matrizesIds;
    private String prerequisitosIds;
    private Long programaId;
}
