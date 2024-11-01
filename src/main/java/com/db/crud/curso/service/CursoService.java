package com.db.crud.curso.service;

import com.db.crud.curso.model.Aluno;
import com.db.crud.curso.model.dto.requestDto.CursoRequestDto;
import com.db.crud.curso.model.dto.requestDto.CursoUpdateDto;
import com.db.crud.curso.model.dto.responseDto.CursoResponseDto;
import com.db.crud.curso.model.mappers.CursoMapper;
import com.db.crud.curso.model.Curso;
import com.db.crud.curso.repository.AlunoRepository;
import com.db.crud.curso.repository.CursoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    private final CursoMapper cursoMapper = CursoMapper.INSTANCE;

    public CursoResponseDto cadastrarCurso(CursoRequestDto content) {
        Curso curso = cursoMapper.toEntity(content);
        cursoRepository.save(curso);
        return cursoMapper.cursoToReponseDto(curso);
    }

    public CursoResponseDto atualizarCurso(CursoUpdateDto content, Long matricula) {
        Curso curso = cursoRepository.findByMatricula(matricula).orElseThrow(() -> new RuntimeException("not found"));
        cursoMapper.atualizar(content, curso);
        cursoRepository.save(curso);
        return cursoMapper.cursoToReponseDto(curso);
    }

    public List<CursoResponseDto> listaTodosCurso() {
        return cursoRepository.findAll()
                .stream()
                .map(cursoMapper::cursoToReponseDto)
                .collect(Collectors.toList());
    }

    public List<String> listarTodosAlunosDoCurso(String nome) {
        return cursoRepository.findByAlunosDoCurso(nome);



    }

    public void excluirCurso(Long matricula) {
        Curso curso = cursoRepository.findByMatricula(matricula).orElseThrow(() -> new RuntimeException("Not found!"));
        cursoRepository.delete(curso);
    }

    @Transactional
    public CursoResponseDto vincularAlunoACurso(Long matriculaCurso, Long matriculaAluno) {
        Aluno aluno = alunoRepository.findByMatricula(matriculaAluno).orElseThrow(() -> new RuntimeException("Not found!"));
        Curso curso = cursoRepository.findByMatricula(matriculaCurso).orElseThrow(() -> new RuntimeException("Not found!"));

        if(!curso.getAlunos().contains(aluno)) {
            curso.getAlunos().add(aluno);
            aluno.getCursos().add(curso);
            cursoRepository.save(curso);
            alunoRepository.save(aluno);
        }

        return cursoMapper.cursoToReponseDto(curso);
    }


}
