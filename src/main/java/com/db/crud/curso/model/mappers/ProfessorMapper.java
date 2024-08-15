package com.db.crud.curso.model.mappers;

import com.db.crud.curso.model.Aluno;
import com.db.crud.curso.model.Professor;
import com.db.crud.curso.model.dto.requestDto.ProfessorRequestDto;
import com.db.crud.curso.model.dto.requestDto.ProfessorUpdateDto;
import com.db.crud.curso.model.dto.responseDto.AlunoUpdateDto;
import com.db.crud.curso.model.dto.responseDto.ProfessorResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ProfessorMapper {

    ProfessorMapper INSTANCE = Mappers.getMapper(ProfessorMapper.class);

    ProfessorResponseDto professorResponseToDto(Professor professor);

    @Mapping(target = "id", ignore = true)
    Professor toEntity(ProfessorRequestDto dto);

    void atualizarEntityFromDto(ProfessorUpdateDto professorUpdateDto, @MappingTarget Professor professor);

}
