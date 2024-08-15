package com.db.crud.curso.service;

import com.db.crud.curso.model.Aluno;
import com.db.crud.curso.model.Curso;
import com.db.crud.curso.model.dto.requestDto.AlunoRequestDto;
import com.db.crud.curso.model.dto.responseDto.AlunoResponseDto;
import com.db.crud.curso.model.dto.requestDto.AlunoUpdateDto;
import com.db.crud.curso.model.mappers.AlunoMapper;
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
public class AlunoService {

    private final AlunoMapper alunoMapper = AlunoMapper.INSTANCE;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public AlunoResponseDto cadastrarAluno(AlunoRequestDto content) {
        Aluno aluno = alunoMapper.toEntity(content);
        alunoRepository.save(aluno);
        return  alunoMapper.alunoResponseToDto(aluno);
    }

    public AlunoResponseDto atualizarAluno(AlunoUpdateDto content, Long id) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        alunoMapper.atualizarEntityFromDto(content, aluno);
        alunoRepository.save(aluno);
        return alunoMapper.alunoResponseToDto(aluno);
    }

    public List<AlunoResponseDto> listarAlunos() {
        return alunoRepository.findAll()
                .stream()
                .map(alunoMapper::alunoResponseToDto)
                .collect(Collectors.toList());
    }

    public void excluirAluno(Long id) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found!"));
        alunoRepository.delete(aluno);
    }

//    todo
//    @Transactional
//    public void desvincularAlunoDoCurso(Long matriculaAluno, Long matriculaCurso) {
//        Aluno aluno = alunoRepository.findByMatricula(matriculaAluno)
//                .orElseThrow(() -> new RuntimeException("Aluno not found!"));
//        Curso curso = cursoRepository.findByMatricula(matriculaCurso)
//                .orElseThrow(() -> new RuntimeException("Curso not found!"));
//
//        if(curso.getAlunos().contains(aluno)) {
//            aluno.getCursos().remove(curso);
//            alunoRepository.save(aluno);
//        }
//    }
//
//    public boolean verificarCadastroNoCurso(Long matricula, String nome) {
//        return alunoRepository.isAlunoCadastradoNoCurso(matricula, nome);
//    }
}
