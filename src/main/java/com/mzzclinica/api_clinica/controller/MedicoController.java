package com.mzzclinica.api_clinica.controller;



import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mzzclinica.api_clinica.medico.DadosMedico;
import com.mzzclinica.api_clinica.medico.Medico;
import com.mzzclinica.api_clinica.repository.MedicoRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/medicos")
@AllArgsConstructor
public class MedicoController {

    @Autowired
    private final MedicoRepository repository;

    @PostMapping
    public void cadastrarMedico(@RequestBody @Valid DadosMedico dadosMedico) {
        repository.save(new Medico(dadosMedico));
    }

    @GetMapping
    public Page<DadosListagemMedico> listarMedicos(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemMedico::new);
    }
    
}
