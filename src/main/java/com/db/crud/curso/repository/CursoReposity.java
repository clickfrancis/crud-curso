package com.db.crud.curso.repository;

import com.db.crud.curso.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CursoReposity extends JpaRepository<Curso, Long> {

    void findByMatricula(Long matricula);

    @Query("SELECT curso.nome AS curso_nome, professor.nome AS professor_nome, aluno.nome AS aluno_nome " +
            "FROM cursos curso " +
            "JOIN curso.professor professor " +
            "JOIN curso.alunos aluno " +
            "WHERE curso.matricula = :matricula")
    List<Curso> findByCursoCompleto(@Param("matricula") Long matricula);
}

