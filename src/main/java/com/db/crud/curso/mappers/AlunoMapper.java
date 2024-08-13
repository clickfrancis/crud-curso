package com.db.crud.curso.mappers;

import com.db.crud.curso.dto.responseDto.AlunoNomeResponseDto;
import com.db.crud.curso.model.Aluno;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AlunoMapper {

    AlunoMapper INSTANCE = Mappers.getMapper(AlunoMapper.class);

    AlunoNomeResponseDto alunoNomeRespnseToDto(Aluno aluno);
}
