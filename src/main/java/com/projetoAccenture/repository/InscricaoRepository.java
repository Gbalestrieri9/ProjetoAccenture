package com.projetoAccenture.repository;

import com.projetoAccenture.domain.inscricao.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao,Long> {

    List<Inscricao> alunoPorId(Long alunoId);
    List<Inscricao> cursoPorId(Long cursoId);
}
