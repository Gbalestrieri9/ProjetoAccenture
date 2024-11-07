package com.projetoAccenture.service;

import com.projetoAccenture.domain.aluno.Aluno;
import com.projetoAccenture.domain.curso.Curso;
import com.projetoAccenture.domain.inscricao.Inscricao;
import com.projetoAccenture.repository.AlunoRepository;
import com.projetoAccenture.repository.CursoRepository;
import com.projetoAccenture.repository.InscricaoRepository;
import com.projetoAccenture.util.ConstantesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class InscricaoService {

    @Autowired
    private InscricaoRepository inscricaoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public ResponseEntity<?> inscreverAlunoEmCurso(Long alunoId, Long cursoId) {
        Optional<Aluno> alunoOpt = alunoRepository.findById(alunoId);
        Optional<Curso> cursoOpt = cursoRepository.findById(cursoId);

        if (alunoOpt.isEmpty() || cursoOpt.isEmpty()) {
            return ResponseEntity.badRequest().body(ConstantesUtil.MENSAGEM_ERRO_INSCRICAO_CURSO);
        }

        Inscricao inscricao = new Inscricao();
        inscricao.setAluno(alunoOpt.get());
        inscricao.setCurso(cursoOpt.get());
        inscricao.setDataInscricao(new Date());

        inscricaoRepository.save(inscricao);
        return ResponseEntity.ok(ConstantesUtil.MENSAGEM_SUCESSO_INSCRICAO_CURSO);
    }
}
