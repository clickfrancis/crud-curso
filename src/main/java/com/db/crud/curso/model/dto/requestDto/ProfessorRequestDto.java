package com.db.crud.curso.model.dto.requestDto;

import jakarta.validation.constraints.NotBlank;

public record ProfessorRequestDto(

        @NotBlank(message = "name must not be null")
        String nome
) {
}
