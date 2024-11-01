package com.db.crud.curso.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "nome_aluno")
    private String nome;

    @NotNull
    @Column(name = "matricula_aluno", unique = true)
    private Long matricula;

    @ManyToMany
    @JoinTable(
            name = "alunos_cursos",
            joinColumns = @JoinColumn(name = "alunos_id"),
            inverseJoinColumns = @JoinColumn(name = "cursos_id")
    )
    List<Curso> cursos;
}
