package com.db.crud.curso.controller;

import com.db.crud.curso.model.Professor;
import com.db.crud.curso.model.dto.requestDto.ProfessorRequestDto;
import com.db.crud.curso.model.dto.requestDto.ProfessorUpdateDto;
import com.db.crud.curso.model.dto.responseDto.ProfessorResponseDto;
import com.db.crud.curso.service.ProfessorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping(value = "/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @PostMapping
    public ResponseEntity<ProfessorResponseDto> cadastrarProfessor(@RequestBody @Valid ProfessorRequestDto content) {
        ProfessorResponseDto novoProfessor = professorService.cadastrarProfessor(content);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProfessor);
    }

    @GetMapping
    public ResponseEntity<List<ProfessorResponseDto>> listarTodosProfessores() {
        return ResponseEntity.status(HttpStatus.OK).body(professorService.listarTodosProfessores());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorResponseDto> atualizarProfessor(@RequestBody ProfessorUpdateDto content, @PathVariable Long id) {
        ProfessorResponseDto professorAtualizado = professorService.atualizarProfessor(content, id);
        return ResponseEntity.status(HttpStatus.OK).body(professorAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProfessor(@PathVariable Long id) {
        professorService.deletarProfessor(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
