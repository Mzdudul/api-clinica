package com.mzzclinica.api_clinica.domain.consultas.validacoes;

import java.time.DayOfWeek;

import org.springframework.stereotype.Component;

import com.mzzclinica.api_clinica.domain.ValidacaoException;
import com.mzzclinica.api_clinica.domain.consultas.DadosAgendamentoConsulta;
@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsultas{
    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antedDaAbertura = dataConsulta.getHour() < 7;
        var depoisDoFechamento = dataConsulta.getHour() >= 18;

        if(domingo || antedDaAbertura || depoisDoFechamento) {
            throw new ValidacaoException("Consulta fora do horário de funcionamento da clínica");
        }
    }
}
