package com.RevisaoSpring.revisaoSpring.model;

import com.RevisaoSpring.revisaoSpring.model.dto.DisciplinaProfessorDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_disciplina")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany
    @JoinTable(
            name = "tb_disciplina_professor",
            joinColumns = @JoinColumn(name = "id_disciplina"),
            inverseJoinColumns =  @JoinColumn(name = "id_professor")

    )
    private List<Professor> professor;

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

    public List<Professor> getProfessor() {
        return professor;
    }

    public void setProfessor(List<Professor> professor) {
        this.professor = professor;
    }

    public DisciplinaProfessorDTO toDisciplinaProfessorDTO(){
        return new DisciplinaProfessorDTO(this.id, this.nome);
    }
}
