package com.RevisaoSpring.revisaoSpring.model.dto;


import com.RevisaoSpring.revisaoSpring.model.Disciplina;

import java.util.List;

public record ProfessorGetDTO(
        Long id,
        String nome,
        List<DisciplinaProfessorDTO> disciplinas
) {

}
