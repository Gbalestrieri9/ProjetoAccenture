package com.projetoAccenture.dto;

import com.projetoAccenture.domain.aluno.Aluno;
import com.projetoAccenture.domain.curso.Curso;
import org.springframework.stereotype.Component;

@Component
public class InscricaoPopulator {

    public AlunoDto alunoResponse(Aluno aluno) {
        AlunoDto alunoDto = new AlunoDto();
        alunoDto.setId(aluno.getId());
        alunoDto.setNome(aluno.getNome());
        alunoDto.setEmail(aluno.getEmail());
        alunoDto.setDataCadastro(aluno.getDataCadastro());
        return alunoDto;
    }

    public CursoDto cursoResponse(Curso curso) {
        CursoDto cursoDto = new CursoDto();
        cursoDto.setId(curso.getId());
        cursoDto.setNome(curso.getNome());
        cursoDto.setDescricao(curso.getDescricao());
        cursoDto.setDataCriacao(curso.getDataCriacao());
        return cursoDto;
    }

    public Aluno alunoRequest(AlunoDto alunoDto) {
        Aluno aluno = new Aluno();
        aluno.setId(alunoDto.getId());
        aluno.setNome(alunoDto.getNome());
        aluno.setEmail(alunoDto.getEmail());
        aluno.setDataCadastro(alunoDto.getDataCadastro());
        return aluno;
    }

    public Curso cursoRequest(CursoDto cursoDto) {
        Curso curso = new Curso();
        curso.setId(cursoDto.getId());
        curso.setNome(cursoDto.getNome());
        curso.setDescricao(cursoDto.getDescricao());
        curso.setDataCriacao(cursoDto.getDataCriacao());
        return curso;
    }
}
