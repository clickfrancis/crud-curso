package com.db.crud.curso.model.dto.responseDto;

import com.db.crud.curso.model.Aluno;

import java.util.List;

public record CursoAlunoListResponseDto(

        String nome,
        List<Aluno> aluno
) {
}
