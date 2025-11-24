package com.ucsal.disciplina_microsservice.model.service;

import com.ucsal.disciplina_microsservice.controller.dto.request.MatrizRequestDTO;
import com.ucsal.disciplina_microsservice.controller.dto.response.MatrizResponseDTO;
import com.ucsal.disciplina_microsservice.model.entity.Matriz;
import com.ucsal.disciplina_microsservice.model.repository.MatrizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatrizService {

    private final MatrizRepository repository;

    private MatrizResponseDTO toDTO(Matriz entity) {
        MatrizResponseDTO dto = new MatrizResponseDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setTurnoPadrao(entity.getTurnoPadrao());
        dto.setCampus(entity.getCampus());
        dto.setHabilitacao(entity.getHabilitacao());
        dto.setHorasAtividadesComplementares(entity.getHorasAtividadesComplementares());
        dto.setHorasDisciplinasObrigatorias(entity.getHorasDisciplinasObrigatorias());
        dto.setHorasDisciplinasExtras(entity.getHorasDisciplinasExtras());
        dto.setHorasTCC(entity.getHorasTCC());
        dto.setCursoId(entity.getCursoId());
        dto.setDisciplinasIds(entity.getDisciplinasIds());
        return dto;
    }

    private Matriz toEntity(MatrizRequestDTO dto) {
        Matriz m = new Matriz();
        m.setNome(dto.getNome());
        m.setTurnoPadrao(dto.getTurnoPadrao());
        m.setCampus(dto.getCampus());
        m.setHabilitacao(dto.getHabilitacao());
        m.setHorasAtividadesComplementares(dto.getHorasAtividadesComplementares());
        m.setHorasDisciplinasObrigatorias(dto.getHorasDisciplinasObrigatorias());
        m.setHorasDisciplinasExtras(dto.getHorasDisciplinasExtras());
        m.setHorasTCC(dto.getHorasTCC());
        m.setCursoId(dto.getCursoId());
        m.setDisciplinasIds(dto.getDisciplinasIds());
        return m;
    }

    public MatrizResponseDTO criar(MatrizRequestDTO dto) {
        return toDTO(repository.save(toEntity(dto)));
    }

    public MatrizResponseDTO buscarPorId(Long id) {
        return repository.findById(id).map(this::toDTO).orElse(null);
    }

    public List<MatrizResponseDTO> listar() {
        return repository.findAll().stream().map(this::toDTO).toList();
    }

    public MatrizResponseDTO atualizar(Long id, MatrizRequestDTO dto) {
        return repository.findById(id)
                .map(existente -> {
                    existente.setNome(dto.getNome());
                    existente.setTurnoPadrao(dto.getTurnoPadrao());
                    existente.setCampus(dto.getCampus());
                    existente.setHabilitacao(dto.getHabilitacao());
                    existente.setHorasAtividadesComplementares(dto.getHorasAtividadesComplementares());
                    existente.setHorasDisciplinasObrigatorias(dto.getHorasDisciplinasObrigatorias());
                    existente.setHorasDisciplinasExtras(dto.getHorasDisciplinasExtras());
                    existente.setHorasTCC(dto.getHorasTCC());
                    existente.setCursoId(dto.getCursoId());
                    existente.setDisciplinasIds(dto.getDisciplinasIds());
                    return toDTO(repository.save(existente));
                })
                .orElse(null);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}

