package com.RevisaoSpring.revisaoSpring.model;


import com.RevisaoSpring.revisaoSpring.model.dto.ProfessorGetDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "tb_professor")
public class Professor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(length =  200)
    private String nome;

    @ManyToMany(mappedBy = "professor", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Disciplina> disciplinas;

    public Professor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public ProfessorGetDTO toGetDTO(){
        return new ProfessorGetDTO(id, nome,disciplinas.stream().map(Disciplina::toDisciplinaProfessorDTO).toList());
    }
}
