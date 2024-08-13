package com.db.crud.curso.service;

import com.db.crud.curso.model.Aluno;
import com.db.crud.curso.model.dto.responseDto.AlunoNomeResponseDto;
import com.db.crud.curso.model.dto.responseDto.AlunoRequestDto;
import com.db.crud.curso.model.dto.responseDto.AlunoResponseDto;
import com.db.crud.curso.model.dto.responseDto.AlunoUpdateDto;
import com.db.crud.curso.model.mappers.AlunoMapper;
import com.db.crud.curso.repository.AlunoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class AlunoService {

    private AlunoMapper alunoMapper;

    @Autowired
    private AlunoRepository alunoRepository;

    public AlunoService(AlunoMapper alunoMapper) {
        this.alunoMapper = alunoMapper;
    }

    public AlunoResponseDto cadastrarAluno(AlunoRequestDto alunoRequestDto) {
        Aluno aluno = alunoMapper.alunoToEntity(alunoRequestDto);
        alunoRepository.save(aluno);
        return  alunoMapper.alunoResponseToDto(aluno);
    }

    public AlunoResponseDto atualizarAluno(AlunoUpdateDto alunoUpdateDto) {
        Aluno aluno = alunoRepository.findByMatricula(alunoUpdateDto.matricula()).orElseThrow(() -> new RuntimeException("Not found"));
        alunoMapper.atualizarEntityFromDto(alunoUpdateDto, aluno);
        alunoRepository.save(aluno);
        return alunoMapper.alunoResponseToDto(aluno);
    }

    public List<AlunoResponseDto> listarAlunos() {
        return alunoRepository.findAll()
                .stream()
                .map(alunoMapper::alunoResponseToDto)
                .collect(Collectors.toList());
    }

}
