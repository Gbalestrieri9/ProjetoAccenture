package com.projetoAccenture.controller;

import com.projetoAccenture.dto.AlunoDto;
import com.projetoAccenture.dto.CursoDto;
import com.projetoAccenture.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public CursoDto cadastrarCurso(@RequestBody CursoDto cursoDTO) {
        return cursoService.cadastrarCurso(cursoDTO);
    }

    @GetMapping("/{cursoId}/alunos")
    public List<AlunoDto> listarAlunosDoCurso(@PathVariable Long cursoId) {
        return cursoService.listarAlunosDoCurso(cursoId);
    }
}
