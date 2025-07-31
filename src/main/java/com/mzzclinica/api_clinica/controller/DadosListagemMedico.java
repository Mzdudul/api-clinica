package com.mzzclinica.api_clinica.controller;

import com.mzzclinica.api_clinica.medico.Medico;

public record DadosListagemMedico(String nome, String email, String crm, String especialidade) {
      
    public DadosListagemMedico(Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade().toString());
    }
} 