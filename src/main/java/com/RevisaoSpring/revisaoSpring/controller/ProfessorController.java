package com.RevisaoSpring.revisaoSpring.controller;

import com.RevisaoSpring.revisaoSpring.model.Professor;
import com.RevisaoSpring.revisaoSpring.model.dto.ProfessorGetDTO;
import com.RevisaoSpring.revisaoSpring.model.dto.ProfessorPostDTO;
import com.RevisaoSpring.revisaoSpring.service.ProfessorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    private final ProfessorService service;

    public ProfessorController(ProfessorService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProfessorGetDTO buscarProfessorPorId(@PathVariable Long id){
        return service.buscarPorId(id).toGetDTO();
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Professor> buscarProfessores(){
        return service.buscarTodos();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProfessorGetDTO criarProfessor(@RequestBody @Valid ProfessorPostDTO  professorPostDTO){

        return service.salvar(professorPostDTO).toGetDTO();
    }
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ProfessorGetDTO atualizarProfessor(@RequestBody Professor professor){
        return service.atualizar(professor).toGetDTO();
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarProfessorPorId(@PathVariable Long id){
         service.removerProfessor(id);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public ProfessorGetDTO removerDisciplinaProfessor(
            @RequestParam Long idDisciplina,
            @RequestParam Long idProfessor
    ){
        return service.removerDisciplinaProfessor(idDisciplina,idProfessor).toGetDTO();
    }

}
