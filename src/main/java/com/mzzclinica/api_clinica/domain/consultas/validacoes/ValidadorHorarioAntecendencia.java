package com.mzzclinica.api_clinica.domain.consultas.validacoes;

import java.time.Duration;
import java.time.LocalDateTime;

import com.mzzclinica.api_clinica.domain.ValidacaoException;
import com.mzzclinica.api_clinica.domain.consultas.DadosAgendamentoConsulta;

public class ValidadorHorarioAntecendencia {

    public void validarAntecedencia(DadosAgendamentoConsulta dados) {

        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if(diferencaEmMinutos < 30) {
            throw new ValidacaoException("Consulta deve ser agendada com pelo menos 30 minutos de antecedência");
        }

    }
}
