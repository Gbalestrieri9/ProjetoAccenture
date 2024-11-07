package com.projetoAccenture.controller;

import com.projetoAccenture.service.InscricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inscricao")
public class InscricaoController {

    @Autowired
    private InscricaoService inscricaoService;

    @PostMapping
    public ResponseEntity<?> inscreverAlunoEmCurso(@RequestParam Long alunoId, @RequestParam Long cursoId) {
        return inscricaoService.inscreverAlunoEmCurso(alunoId, cursoId);
    }
}
