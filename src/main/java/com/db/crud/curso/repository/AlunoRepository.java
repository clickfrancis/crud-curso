package com.db.crud.curso.repository;

import com.db.crud.curso.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Optional<Aluno> findByMatricula(Long matricula);

    @Transactional
    @Query(value = """
            SELECT Count (a.nome_aluno) > 0
            FROM cursos c
            JOIN alunos_cursos ac ON c.id = ac.cursos_id
            JOIN alunos a ON ac.alunos_id = a.id
            WHERE c.nome_curso = :nome
            and a.matricula_aluno = :matricula
            """ , nativeQuery = true)
    boolean isAlunoCadastradoNoCurso(@Param("matricula") Long matricula, @Param("nome") String nome);
}
