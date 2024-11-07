package com.projetoAccenture.repository;

import com.projetoAccenture.domain.aluno.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno,Long> {

    boolean existeEmail(String email);
}
