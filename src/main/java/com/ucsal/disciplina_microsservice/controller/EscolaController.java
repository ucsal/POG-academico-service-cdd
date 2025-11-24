package com.ucsal.disciplina_microsservice.controller;

import com.ucsal.disciplina_microsservice.controller.dto.request.EscolaRequestDTO;
import com.ucsal.disciplina_microsservice.controller.dto.response.EscolaResponseDTO;
import com.ucsal.disciplina_microsservice.model.service.EscolaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/escolas")
public class EscolaController {

    private final EscolaService service;

    @PostMapping
    public ResponseEntity<EscolaResponseDTO> criar(@RequestBody EscolaRequestDTO dto) {
        return ResponseEntity.ok(service.criar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EscolaResponseDTO> buscarPorId(@PathVariable Long id) {
        EscolaResponseDTO dto = service.buscarPorId(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<EscolaResponseDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EscolaResponseDTO> atualizar(@PathVariable Long id,
                                                       @RequestBody EscolaRequestDTO dto) {
        EscolaResponseDTO atualizado = service.atualizar(id, dto);
        return atualizado != null ? ResponseEntity.ok(atualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
