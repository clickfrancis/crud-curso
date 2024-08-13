package com.db.crud.curso.service;

import com.db.crud.curso.dto.requestDto.CursoRequestDto;
import com.db.crud.curso.dto.responseDto.CursoAlunoListResponseDto;
import com.db.crud.curso.dto.responseDto.CursoResponseDto;
import com.db.crud.curso.mappers.AlunoMapper;
import com.db.crud.curso.mappers.CursoMapper;
import com.db.crud.curso.model.Curso;
import com.db.crud.curso.repository.CursoReposity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CursoService {

    @Autowired
    CursoReposity cursoReposity;

    private CursoMapper cursoMapper;

    private AlunoMapper alunoMapper;

    public CursoService(CursoMapper cursoMapper) {
        this.cursoMapper = cursoMapper;
    }

    public CursoResponseDto criarCurso(CursoRequestDto cursoRequestDto) {
        Curso curso = cursoMapper.toEntity(cursoRequestDto);
        cursoReposity.save(curso);
        return cursoMapper.cursoToReponseDto(curso);
    }

    public CursoResponseDto atualizarCurso(CursoRequestDto cursoRequestDto) {
        Curso curso = cursoReposity.findByMatricula(cursoRequestDto.matricula()).orElseThrow(() -> new RuntimeException("not found"));
        cursoMapper.atualizar(cursoRequestDto, curso);
        return cursoMapper.cursoToReponseDto(curso);
    }

    public List<CursoResponseDto> listaTodosCurso() {
        return cursoReposity.findAll()
                .stream()
                .map(cursoMapper::cursoToReponseDto)
                .collect(Collectors.toList());
    }

    public List<CursoAlunoListResponseDto> listarTodosAlunosDoCurso(String nome) {
        return cursoReposity.findByAlunosDoCurso(nome)
                .stream()
                .map(cursoMapper::cursoAlunoListToReponseDto)
                .collect(Collectors.toList());
    }

    public void deletarCurso(Long matricula) {
        Curso curso = cursoReposity.findByMatricula(matricula).orElseThrow(() -> new RuntimeException("Not found!"));
        cursoReposity.delete(curso);
    }

}
