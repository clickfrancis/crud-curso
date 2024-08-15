package com.db.crud.curso.repository;

import com.db.crud.curso.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    @Transactional
    @Query(value = """
            SELECT a.nome_aluno
            FROM cursos c
            JOIN alunos_cursos ac ON c.id = ac.cursos_id
            JOIN alunos a ON ac.alunos_id = a.id
            WHERE c.nome_curso = :nome
            """,
            nativeQuery = true
    )
    List<String> findByAlunosDoCurso(@Param("nome") String nome);

}

