package com.db.crud.curso.model.dto.responseDto;

import jakarta.validation.constraints.NotBlank;

public record ProfessorResponseDto(

        @NotBlank(message = "name must not be null")
        String nome
) {
}
