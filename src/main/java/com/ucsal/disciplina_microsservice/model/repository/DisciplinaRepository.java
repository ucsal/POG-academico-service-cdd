package com.ucsal.disciplina_microsservice.model.repository;

import com.ucsal.disciplina_microsservice.model.entity.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}

