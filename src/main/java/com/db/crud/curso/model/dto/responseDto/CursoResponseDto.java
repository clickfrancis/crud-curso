package com.db.crud.curso.model.dto.responseDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CursoResponseDto(
        @NotBlank(message = "name must not be null")
        String nome,

        List<AlunoResponseDto> alunos
) {
}
