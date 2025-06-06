package com.RevisaoSpring.revisaoSpring.repository;

import com.RevisaoSpring.revisaoSpring.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}
