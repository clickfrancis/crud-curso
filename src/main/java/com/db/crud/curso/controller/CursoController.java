package com.db.crud.curso.controller;

import com.db.crud.curso.model.dto.requestDto.CursoRequestDto;
import com.db.crud.curso.model.dto.requestDto.CursoUpdateDto;
import com.db.crud.curso.model.dto.responseDto.CursoAlunoListResponseDto;
import com.db.crud.curso.model.dto.responseDto.CursoResponseDto;
import com.db.crud.curso.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<CursoResponseDto> cadastrarAluno(@RequestBody @Valid CursoRequestDto content) {
        CursoResponseDto novoCurso = cursoService.cadastrarCurso(content);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCurso);
    }

    @GetMapping
    public ResponseEntity<List<CursoResponseDto>> listaCursos() {
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.listaTodosCurso());
    }

    @GetMapping("/{nome}")
    public ResponseEntity<List<String>> listaAlunosDoCurso(@PathVariable String nome) {
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.listarTodosAlunosDoCurso(nome));
    }

    @PutMapping("/{matricula}")
    public ResponseEntity<CursoResponseDto> atualizarAluno(@RequestBody @Valid CursoUpdateDto content, @Valid @PathVariable Long matricula) {
        CursoResponseDto cursoAtualizado = cursoService.atualizarCurso(content, matricula);
        return ResponseEntity.status(HttpStatus.OK).body(cursoAtualizado);
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity<Void> excluirAluno(@PathVariable Long matricula) {
        cursoService.excluirCurso(matricula);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/{matriculaCurso}/alunos/{matriculaAluno}")
    public ResponseEntity<CursoResponseDto> associarAluno(@PathVariable Long matriculaCurso, @PathVariable Long matriculaAluno) {
        CursoResponseDto alunoAdicionado = cursoService.vincularAlunoACurso(matriculaCurso, matriculaAluno);
        return ResponseEntity.status(HttpStatus.OK).body(alunoAdicionado);
    }
}