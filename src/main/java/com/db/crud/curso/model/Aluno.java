package com.db.crud.curso.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @Column(name = "nome_aluno")
    private String nome;

    @NotBlank
    @Column(name = "matricula_aluno")
    private Long matricula;

    @ManyToMany
    List<Curso> cursos;
}
