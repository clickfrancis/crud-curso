package com.db.crud.curso.model.dto.requestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AlunoRequestDto(
        @NotBlank(message = "name must not be null")
        String nome
) {
}
