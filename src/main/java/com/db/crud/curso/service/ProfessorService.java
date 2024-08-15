package com.db.crud.curso.service;

import com.db.crud.curso.model.Professor;
import com.db.crud.curso.model.dto.requestDto.ProfessorRequestDto;
import com.db.crud.curso.model.dto.requestDto.ProfessorUpdateDto;
import com.db.crud.curso.model.dto.responseDto.ProfessorResponseDto;
import com.db.crud.curso.model.mappers.ProfessorMapper;
import com.db.crud.curso.repository.ProfessorRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    private final ProfessorMapper professorMapper = ProfessorMapper.INSTANCE;

    public ProfessorResponseDto cadastrarProfessor(ProfessorRequestDto content){
        Professor professor = professorMapper.toEntity(content);
        professorRepository.save(professor);
        return professorMapper.professorResponseToDto(professor);
    }

    public List<ProfessorResponseDto> listarTodosProfessores() {
        return professorRepository
                .findAll()
                .stream()
                .map(professorMapper::professorResponseToDto)
                .collect(Collectors.toList());
    }

    public ProfessorResponseDto atualizarProfessor(ProfessorUpdateDto content, Long id) {
        Professor professorEncontrado = professorRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found!"));
        professorMapper.atualizarEntityFromDto(content, professorEncontrado);
        professorRepository.save(professorEncontrado);
        return professorMapper.professorResponseToDto(professorEncontrado);
    }

    public void deletarProfessor(Long id) {
        Professor professorEncontrado = professorRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found!"));
        professorRepository.delete(professorEncontrado);
    }
}
