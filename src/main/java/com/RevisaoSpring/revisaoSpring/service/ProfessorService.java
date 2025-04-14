package com.RevisaoSpring.revisaoSpring.service;

import com.RevisaoSpring.revisaoSpring.model.Disciplina;
import com.RevisaoSpring.revisaoSpring.model.Professor;
import com.RevisaoSpring.revisaoSpring.model.dto.ProfessorPostDTO;
import com.RevisaoSpring.revisaoSpring.repository.DisciplinaRepository;
import com.RevisaoSpring.revisaoSpring.repository.ProfessorRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProfessorService {


    public ProfessorService(ProfessorRepository repository, DisciplinaRepository disciplinaRepository) {
        this.repository = repository;
        this.disciplinaRepository = disciplinaRepository;
    }

    private final ProfessorRepository repository;
    private final DisciplinaRepository disciplinaRepository;

    public Professor salvar(ProfessorPostDTO professorPostDTO){

        Professor professor = professorPostDTO.convert();
        List<Professor> professores = new ArrayList<>();
        professores.add(professor);
        professor.getDisciplinas().forEach(disciplina -> disciplina.setProfessor(professores));


        return repository.save(professor);
    }

    public Professor atualizar(Professor professor){
        List<Professor> professores = new ArrayList<>();
        professores.add(professor);
        professor.getDisciplinas().forEach(disciplina -> disciplina.setProfessor(professores));
        return repository.save(professor);
    }
    public Professor buscarPorId(Long id ){
        return repository.findById(id).get();
    }
    public List<Professor> buscarTodos(){
        return  repository.findAll();
    }
    public void removerProfessor(Long id){
        repository.deleteById(id);
    }


    @Transactional
    public Professor removerDisciplinaProfessor(Long idDisciplina, Long idProfessor) {
        Professor professor = this.repository.findById(idProfessor).orElseThrow(NoSuchElementException::new);

        professor.getDisciplinas().removeIf(disciplina -> disciplina.getId().equals(idDisciplina));
        disciplinaRepository.findById(idDisciplina).get().getProfessor().removeIf(professor1 -> professor1.getId().equals(idProfessor));
        return professor;
    }
}
