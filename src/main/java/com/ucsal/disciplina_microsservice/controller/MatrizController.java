package com.ucsal.disciplina_microsservice.controller;

import com.ucsal.disciplina_microsservice.controller.dto.request.MatrizRequestDTO;
import com.ucsal.disciplina_microsservice.controller.dto.response.MatrizResponseDTO;
import com.ucsal.disciplina_microsservice.model.service.MatrizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/matrizes")
public class MatrizController {

    private final MatrizService service;

    @PostMapping
    public ResponseEntity<MatrizResponseDTO> criar(@RequestBody MatrizRequestDTO dto) {
        return ResponseEntity.ok(service.criar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatrizResponseDTO> buscarPorId(@PathVariable Long id) {
        MatrizResponseDTO dto = service.buscarPorId(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<MatrizResponseDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatrizResponseDTO> atualizar(@PathVariable Long id, @RequestBody MatrizRequestDTO dto) {
        MatrizResponseDTO atualizado = service.atualizar(id, dto);
        return atualizado != null ? ResponseEntity.ok(atualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

