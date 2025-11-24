package com.ucsal.disciplina_microsservice.controller.dto.request;

import lombok.Data;

@Data
public class DisciplinaRequestDTO {
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
