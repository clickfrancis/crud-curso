package com.db.crud.curso.model.mappers;

import com.db.crud.curso.model.dto.responseDto.AlunoNomeResponseDto;
import com.db.crud.curso.model.Aluno;
import com.db.crud.curso.model.dto.requestDto.AlunoRequestDto;
import com.db.crud.curso.model.dto.responseDto.AlunoResponseDto;
import com.db.crud.curso.model.dto.responseDto.AlunoUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AlunoMapper {

    AlunoMapper INSTANCE = Mappers.getMapper(AlunoMapper.class);

    AlunoResponseDto alunoResponseToDto(Aluno aluno);

    @Mapping(target = "id", ignore = true)
    Aluno toEntity(AlunoRequestDto dto);

    void atualizarEntityFromDto(AlunoUpdateDto alunoUpdateDto, @MappingTarget Aluno aluno);
}
