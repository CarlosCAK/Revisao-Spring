package com.RevisaoSpring.revisaoSpring.service;

import com.RevisaoSpring.revisaoSpring.model.Disciplina;
import com.RevisaoSpring.revisaoSpring.model.Professor;
import com.RevisaoSpring.revisaoSpring.repository.DisciplinaRepository;
import com.RevisaoSpring.revisaoSpring.repository.ProfessorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class DisciplinaService {


    public DisciplinaService(DisciplinaRepository repository) {
        this.repository = repository;
    }

    private final DisciplinaRepository repository;

    public Disciplina salvar(Disciplina professor){
        return repository.save(professor);
    }

    public Disciplina atualizar(Disciplina professor){
        return repository.save(professor);
    }
    public Disciplina buscarPorId(Long id ){
        return repository.findById(id).get();
    }
    public List<Disciplina> buscarTodos(){
        return  repository.findAll();
    }
    public void removerDisciplina(Long id){
        repository.deleteById(id);
    }
}
