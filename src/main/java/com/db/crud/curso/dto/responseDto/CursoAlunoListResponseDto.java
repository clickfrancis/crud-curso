package com.db.crud.curso.dto.responseDto;

import com.db.crud.curso.model.Aluno;

import java.util.List;

public record CursoAlunoListResponseDto(
        List<Aluno> aluno
) {
}
