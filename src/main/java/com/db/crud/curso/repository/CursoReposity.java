package com.db.crud.curso.repository;

import com.db.crud.curso.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CursoReposity extends JpaRepository<Curso, Long> {

    Optional<Curso> findByMatricula(Long matricula);

    @Query("SELECT aluno.nome AS aluno_nome " +
            "FROM cursos curso " +
            "JOIN curso.alunos aluno " +
            "WHERE curso.nome = :nome")
    List<Curso> findByAlunosDoCurso(@Param("nome") String nome);
}

