package com.db.crud.curso.model.mappers;

import com.db.crud.curso.model.dto.requestDto.CursoRequestDto;
import com.db.crud.curso.model.dto.responseDto.CursoAlunoListResponseDto;
import com.db.crud.curso.model.dto.responseDto.CursoResponseDto;
import com.db.crud.curso.model.Curso;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CursoMapper {

    CursoMapper INSTANCE = Mappers.getMapper(CursoMapper.class);

    CursoRequestDto cursoToRequestDto(Curso curso);

    CursoResponseDto cursoToReponseDto(Curso curso);

    Curso toEntity(CursoRequestDto cursoResquestDto);

    Curso atualizar(CursoRequestDto cursoRequestDto, @MappingTarget Curso curso);

    CursoAlunoListResponseDto cursoAlunoListToReponseDto(Curso curso);

}
