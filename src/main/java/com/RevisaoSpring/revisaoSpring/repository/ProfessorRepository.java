package com.RevisaoSpring.revisaoSpring.repository;

import com.RevisaoSpring.revisaoSpring.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Long> {

//    Professor findByNome(String nome);
//
//    Professor findByEndereco_Rua(String rua);

}
