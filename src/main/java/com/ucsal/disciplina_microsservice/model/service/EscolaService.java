package com.ucsal.disciplina_microsservice.model.service;

import com.ucsal.disciplina_microsservice.controller.dto.request.EscolaRequestDTO;
import com.ucsal.disciplina_microsservice.controller.dto.response.EscolaResponseDTO;
import com.ucsal.disciplina_microsservice.model.entity.Escola;
import com.ucsal.disciplina_microsservice.model.repository.EscolaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EscolaService {

    private final EscolaRepository repository;

    private EscolaResponseDTO toDTO(Escola entity) {
        EscolaResponseDTO dto = new EscolaResponseDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setProfessoresIds(entity.getProfessoresIds());
        dto.setCursosIds(entity.getCursosIds());
        return dto;
    }

    private Escola toEntity(EscolaRequestDTO dto) {
        Escola escola = new Escola();
        escola.setNome(dto.getNome());
        escola.setProfessoresIds(dto.getProfessoresIds());
        escola.setCursosIds(dto.getCursosIds());
        return escola;
    }

    public EscolaResponseDTO criar(EscolaRequestDTO dto) {
        Escola escola = toEntity(dto);
        return toDTO(repository.save(escola));
    }

    public EscolaResponseDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public List<EscolaResponseDTO> listar() {
        return repository.findAll().stream().map(this::toDTO).toList();
    }

    public EscolaResponseDTO atualizar(Long id, EscolaRequestDTO dto) {
        return repository.findById(id)
                .map(e -> {
                    e.setNome(dto.getNome());
                    e.setProfessoresIds(dto.getProfessoresIds());
                    e.setCursosIds(dto.getCursosIds());
                    return toDTO(repository.save(e));
                })
                .orElse(null);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
