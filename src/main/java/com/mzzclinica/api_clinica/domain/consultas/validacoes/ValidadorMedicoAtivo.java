package com.mzzclinica.api_clinica.domain.consultas.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mzzclinica.api_clinica.domain.ValidacaoException;
import com.mzzclinica.api_clinica.domain.consultas.DadosAgendamentoConsulta;

import com.mzzclinica.api_clinica.repository.MedicoRepository;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsultas{

    @Autowired
    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {

        if(dados.idMedico() == null) {
            return;
        }
        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());
        if(Boolean.FALSE.equals(medicoEstaAtivo)) {
            throw new ValidacaoException("Consulta não pode ser agendada com médico inativo");
        }
    }
}   
