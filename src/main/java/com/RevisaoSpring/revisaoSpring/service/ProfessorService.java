package com.RevisaoSpring.revisaoSpring.service;

import com.RevisaoSpring.revisaoSpring.model.Professor;
import com.RevisaoSpring.revisaoSpring.model.dto.ProfessorPostDTO;
import com.RevisaoSpring.revisaoSpring.repository.ProfessorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {


    public ProfessorService(ProfessorRepository repository) {
        this.repository = repository;
    }

    private final ProfessorRepository repository;

    public Professor salvar(ProfessorPostDTO professorPostDTO){


        return repository.save(professorPostDTO.convert());
    }

    public Professor atualizar(Professor professor){
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



}
