package com.mzzclinica.api_clinica.domain.consultas.validacoes;

import org.springframework.stereotype.Component;

import com.mzzclinica.api_clinica.domain.consultas.DadosAgendamentoConsulta;


public interface ValidadorAgendamentoDeConsultas {
    void validar(DadosAgendamentoConsulta dados);
}
