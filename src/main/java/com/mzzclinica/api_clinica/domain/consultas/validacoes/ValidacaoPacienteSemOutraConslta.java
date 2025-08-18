package com.mzzclinica.api_clinica.domain.consultas.validacoes;

import org.springframework.stereotype.Component;

import com.mzzclinica.api_clinica.domain.ValidacaoException;
import com.mzzclinica.api_clinica.domain.consultas.DadosAgendamentoConsulta;
import com.mzzclinica.api_clinica.repository.ConsultaRepository;

@Component
public class ValidacaoPacienteSemOutraConslta implements ValidadorAgendamentoDeConsultas{
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {

        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacientePossuiOutraConsultaNoDia = repository. existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);

        if ((boolean) pacientePossuiOutraConsultaNoDia) {
            throw new ValidacaoException("Paciente já possui uma consulta agendada nesse dia");
        }
    }

    
}
