package com.ucsal.disciplina_microsservice.model.repository;

import com.ucsal.disciplina_microsservice.model.entity.Matriz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatrizRepository extends JpaRepository<Matriz, Long> {
}
