package com.projetoAccenture.controller;

import com.projetoAccenture.dto.AlunoDto;
import com.projetoAccenture.dto.CursoDto;
import com.projetoAccenture.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public AlunoDto cadastrarAluno(@RequestBody AlunoDto alunoDTO) {
        return alunoService.cadastrarAluno(alunoDTO);
    }

    @GetMapping("/{alunoId}/cursos")
    public List<CursoDto> listarCursosDoAluno(@PathVariable Long alunoId) {
        return alunoService.listarCursosDoAluno(alunoId);
    }
}
