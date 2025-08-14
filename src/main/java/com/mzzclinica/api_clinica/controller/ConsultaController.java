package com.mzzclinica.api_clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mzzclinica.api_clinica.domain.consultas.AgendamentoConsultas;
import com.mzzclinica.api_clinica.domain.consultas.DadosAgendamentoConsulta;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private AgendamentoConsultas agendamentoConsultas;
    
    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados) {
        agendamentoConsultas.agendarConsulta(dados);
        return ResponseEntity.ok(new DadosAgendamentoConsulta(null, null, null));
    }

}
