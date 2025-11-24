package com.ucsal.disciplina_microsservice.controller;

import com.ucsal.disciplina_microsservice.controller.dto.request.CursoRequestDTO;
import com.ucsal.disciplina_microsservice.controller.dto.response.CursoResponseDTO;
import com.ucsal.disciplina_microsservice.model.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService service;

    @PostMapping
    public ResponseEntity<CursoResponseDTO> criar(@RequestBody CursoRequestDTO dto) {
        return ResponseEntity.ok(service.criar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoResponseDTO> buscarPorId(@PathVariable Long id) {
        CursoResponseDTO dto = service.buscarPorId(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<CursoResponseDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoResponseDTO> atualizar(@PathVariable Long id,
                                                      @RequestBody CursoRequestDTO dto) {
        CursoResponseDTO atualizado = service.atualizar(id, dto);
        return atualizado != null ? ResponseEntity.ok(atualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
