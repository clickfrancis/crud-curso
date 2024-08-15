package com.db.crud.curso.controller;

import com.db.crud.curso.model.dto.requestDto.AlunoRequestDto;
import com.db.crud.curso.model.dto.responseDto.AlunoResponseDto;
import com.db.crud.curso.model.dto.requestDto.AlunoUpdateDto;
import com.db.crud.curso.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<AlunoResponseDto> cadastrarAluno(@RequestBody @Valid AlunoRequestDto content) {
        AlunoResponseDto novoAluno = alunoService.cadastrarAluno(content);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAluno);
    }

    @GetMapping
    public ResponseEntity<List<AlunoResponseDto>> listaAlunos() {
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.listarAlunos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoResponseDto> atualizarAluno(@RequestBody @Valid AlunoUpdateDto content, @Valid @PathVariable Long id) {
        AlunoResponseDto alunoAtualizado = alunoService.atualizarAluno(content, id);
        return ResponseEntity.status(HttpStatus.OK).body(alunoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAluno(@PathVariable Long id) {
        alunoService.excluirAluno(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
//todo
//    @DeleteMapping("/{matriculaAluno}/cursos/{matriculaCurso}")
//    public ResponseEntity<Void> desvincularAlunoDoCurso(@PathVariable Long matriculaAluno, @PathVariable Long matriculaCurso) {
//        alunoService.desvincularAlunoDoCurso(matriculaAluno, matriculaCurso);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
//todo
//    @GetMapping("/{matricula}/cursos/{nome}")
//    public boolean verificarCadastroNoCurso(@PathVariable Long matricula, @PathVariable String nome) {
//        return alunoService.verificarCadastroNoCurso(matricula, nome);
//    }
}
