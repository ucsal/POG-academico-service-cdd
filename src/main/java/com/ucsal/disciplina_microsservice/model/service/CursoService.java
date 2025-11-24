package com.ucsal.disciplina_microsservice.model.service;

import com.ucsal.disciplina_microsservice.controller.dto.request.CursoRequestDTO;
import com.ucsal.disciplina_microsservice.controller.dto.response.CursoResponseDTO;
import com.ucsal.disciplina_microsservice.model.entity.Curso;
import com.ucsal.disciplina_microsservice.model.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository repository;

    private CursoResponseDTO toDTO(Curso entity) {
        CursoResponseDTO dto = new CursoResponseDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setEscolaId(entity.getEscolaId());
        dto.setMatrizesIds(entity.getMatrizesIds());
        return dto;
    }

    private Curso toEntity(CursoRequestDTO dto) {
        Curso curso = new Curso();
        curso.setNome(dto.getNome());
        curso.setEscolaId(dto.getEscolaId());
        curso.setMatrizesIds(dto.getMatrizesIds());
        return curso;
    }

    public CursoResponseDTO criar(CursoRequestDTO dto) {
        return toDTO(repository.save(toEntity(dto)));
    }

    public CursoResponseDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public List<CursoResponseDTO> listar() {
        return repository.findAll().stream().map(this::toDTO).toList();
    }

    public CursoResponseDTO atualizar(Long id, CursoRequestDTO dto) {
        return repository.findById(id)
                .map(existente -> {
                    existente.setNome(dto.getNome());
                    existente.setEscolaId(dto.getEscolaId());
                    existente.setMatrizesIds(dto.getMatrizesIds());
                    return toDTO(repository.save(existente));
                })
                .orElse(null);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
