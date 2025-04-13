package com.RevisaoSpring.revisaoSpring.model.dto;

import com.RevisaoSpring.revisaoSpring.model.Disciplina;
import com.RevisaoSpring.revisaoSpring.model.Professor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public record ProfessorPostDTO(
        @NotBlank
                @Size(min = 2, max = 40)
        String nome,
        List<Disciplina> disciplinas
) {


    public Professor convert(){
        Professor professor = new Professor();

        professor.setNome(this.nome);
        professor.setDisciplinas(disciplinas);
        return professor;
    }
}
