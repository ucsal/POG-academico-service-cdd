package com.ucsal.disciplina_microsservice.model.repository;

import com.ucsal.disciplina_microsservice.model.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}

