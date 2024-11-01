package com.db.crud.curso.model.mappers;

import com.db.crud.curso.model.dto.requestDto.CursoRequestDto;
import com.db.crud.curso.model.dto.requestDto.CursoUpdateDto;
import com.db.crud.curso.model.dto.responseDto.CursoAlunoListResponseDto;
import com.db.crud.curso.model.dto.responseDto.CursoResponseDto;
import com.db.crud.curso.model.Curso;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CursoMapper {

    CursoMapper INSTANCE = Mappers.getMapper(CursoMapper.class);

    CursoResponseDto cursoToReponseDto(Curso curso);

    @Mapping(target = "id", ignore = true)
    Curso toEntity(CursoRequestDto dto);

    void atualizar(CursoUpdateDto cursoUpdateDto, @MappingTarget Curso curso);

    CursoAlunoListResponseDto cursoAlunoListToReponseDto(Curso curso);

}
