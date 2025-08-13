package com.mzzclinica.api_clinica.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mzzclinica.api_clinica.domain.consultas.DadosAgendamentoConsulta;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
    
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados) {
        System.out.println(dados);
        return ResponseEntity.ok(new DadosAgendamentoConsulta(null, null, null));
    }

}
