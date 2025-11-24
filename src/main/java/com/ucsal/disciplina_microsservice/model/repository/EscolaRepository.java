package com.ucsal.disciplina_microsservice.model.repository;

import com.ucsal.disciplina_microsservice.model.entity.Escola;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EscolaRepository extends JpaRepository<Escola, Long> {
}
