package com.db.crud.curso.repository;

import com.db.crud.curso.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    void findByMatricula(Long matricula);
}
