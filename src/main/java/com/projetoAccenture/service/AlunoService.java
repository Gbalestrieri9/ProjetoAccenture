package com.projetoAccenture.service;

import com.projetoAccenture.domain.aluno.Aluno;
import com.projetoAccenture.domain.inscricao.Inscricao;
import com.projetoAccenture.dto.AlunoDto;
import com.projetoAccenture.dto.CursoDto;
import com.projetoAccenture.dto.InscricaoPopulator;
import com.projetoAccenture.exception.EmailExisteException;
import com.projetoAccenture.repository.AlunoRepository;
import com.projetoAccenture.repository.InscricaoRepository;
import com.projetoAccenture.util.ConstantesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private InscricaoRepository inscricaoRepository;

    @Autowired
    private InscricaoPopulator populator;

    public AlunoDto cadastrarAluno(AlunoDto alunoDTO) {
        if (alunoRepository.existeEmail(alunoDTO.getEmail())) {
            throw new EmailExisteException(ConstantesUtil.MENSAGEM_EMAIL + alunoDTO.getEmail() + ConstantesUtil.MENSAGEM_EMAIL_JA_CADASTRADO);
        }

        Aluno aluno = populator.alunoRequest(alunoDTO);
        Aluno alunoSalvo = alunoRepository.save(aluno);
        return populator.alunoResponse(alunoSalvo);
    }

    public List<CursoDto> listarCursosDoAluno(Long alunoId) {
        List<Inscricao> inscricoes = inscricaoRepository.alunoPorId(alunoId);
        return inscricoes.stream()
                .map(inscricao -> populator.cursoResponse(inscricao.getCurso()))
                .collect(Collectors.toList());
    }
}
