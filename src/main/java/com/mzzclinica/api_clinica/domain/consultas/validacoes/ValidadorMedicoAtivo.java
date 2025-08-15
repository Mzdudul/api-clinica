package com.mzzclinica.api_clinica.domain.consultas.validacoes;

import org.springframework.beans.factory.annotation.Autowired;

import com.mzzclinica.api_clinica.domain.ValidacaoException;
import com.mzzclinica.api_clinica.domain.consultas.DadosAgendamentoConsulta;

import com.mzzclinica.api_clinica.repository.MedicoRepository;

public class ValidadorMedicoAtivo {

    @Autowired
    private MedicoRepository repository;

    public void validarMedicoAtivo(DadosAgendamentoConsulta dados) {

        if(dados.idMedico() == null) {
            return;
        }
        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());
        if(Boolean.FALSE.equals(medicoEstaAtivo)) {
            throw new ValidacaoException("Consulta não pode ser agendada com médico inativo");
        }
    }
}   
