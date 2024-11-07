package com.projetoAccenture.service;

import com.projetoAccenture.domain.curso.Curso;
import com.projetoAccenture.domain.inscricao.Inscricao;
import com.projetoAccenture.dto.AlunoDto;
import com.projetoAccenture.dto.CursoDto;
import com.projetoAccenture.dto.InscricaoPopulator;
import com.projetoAccenture.repository.CursoRepository;
import com.projetoAccenture.repository.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private InscricaoRepository inscricaoRepository;

    @Autowired
    private InscricaoPopulator populator;

    public CursoDto cadastrarCurso(CursoDto cursoDTO) {
        Curso curso = populator.cursoRequest(cursoDTO);
        Curso cursoSalvo = cursoRepository.save(curso);
        return populator.cursoResponse(cursoSalvo);
    }

    public List<AlunoDto> listarAlunosDoCurso(Long cursoId) {
        List<Inscricao> inscricoes = inscricaoRepository.cursoPorId(cursoId);
        return inscricoes.stream()
                .map(inscricao -> populator.alunoResponse(inscricao.getAluno()))
                .collect(Collectors.toList());
    }
}
