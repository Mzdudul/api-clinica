package com.mzzclinica.api_clinica.controller;

import com.mzzclinica.api_clinica.domain.endereco.Endereco;
import com.mzzclinica.api_clinica.domain.medico.Especialidade;
import com.mzzclinica.api_clinica.domain.medico.Medico;

public record DetalhamentoMedico(Long id, String nome, String email, String crm, Especialidade especialidade, Endereco endereco) {

    public DetalhamentoMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade(), medico.getEndereco());
    }

}
