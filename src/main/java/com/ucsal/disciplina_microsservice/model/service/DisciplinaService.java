package com.ucsal.disciplina_microsservice.model.service;

import com.ucsal.disciplina_microsservice.controller.dto.request.DisciplinaRequestDTO;
import com.ucsal.disciplina_microsservice.controller.dto.response.DisciplinaResponseDTO;
import com.ucsal.disciplina_microsservice.model.entity.Disciplina;
import com.ucsal.disciplina_microsservice.model.repository.DisciplinaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DisciplinaService {

    private final DisciplinaRepository repository;

    private DisciplinaResponseDTO toDTO(Disciplina entity) {
        DisciplinaResponseDTO dto = new DisciplinaResponseDTO();
        dto.setId(entity.getId());
        dto.setSigla(entity.getSigla());
        dto.setDescricao(entity.getDescricao());
        dto.setCargaHoraria(entity.getCargaHoraria());
        dto.setTipo(entity.getTipo());
        dto.setClassificacao(entity.getClassificacao());
        dto.setAtiva(entity.isAtiva());
        dto.setMatrizesIds(entity.getMatrizesIds());
        dto.setPrerequisitosIds(entity.getPrerequisitosIds());
        dto.setProgramaId(entity.getProgramaId());
        return dto;
    }

    private Disciplina toEntity(DisciplinaRequestDTO dto) {
        Disciplina d = new Disciplina();
        d.setSigla(dto.getSigla());
        d.setDescricao(dto.getDescricao());
        d.setCargaHoraria(dto.getCargaHoraria());
        d.setTipo(dto.getTipo());
        d.setClassificacao(dto.getClassificacao());
        d.setAtiva(dto.isAtiva());
        d.setMatrizesIds(dto.getMatrizesIds());
        d.setPrerequisitosIds(dto.getPrerequisitosIds());
        d.setProgramaId(dto.getProgramaId());
        return d;
    }

    public DisciplinaResponseDTO criar(DisciplinaRequestDTO dto) {
        return toDTO(repository.save(toEntity(dto)));
    }

    public DisciplinaResponseDTO buscarPorId(Long id) {
        return repository.findById(id).map(this::toDTO).orElse(null);
    }

    public List<DisciplinaResponseDTO> listar() {
        return repository.findAll().stream().map(this::toDTO).toList();
    }

    public DisciplinaResponseDTO atualizar(Long id, DisciplinaRequestDTO dto) {
        return repository.findById(id)
                .map(existente -> {
                    existente.setSigla(dto.getSigla());
                    existente.setDescricao(dto.getDescricao());
                    existente.setCargaHoraria(dto.getCargaHoraria());
                    existente.setTipo(dto.getTipo());
                    existente.setClassificacao(dto.getClassificacao());
                    existente.setAtiva(dto.isAtiva());
                    existente.setMatrizesIds(dto.getMatrizesIds());
                    existente.setPrerequisitosIds(dto.getPrerequisitosIds());
                    existente.setProgramaId(dto.getProgramaId());
                    return toDTO(repository.save(existente));
                })
                .orElse(null);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
