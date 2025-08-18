package com.mzzclinica.api_clinica.domain.consultas.validacoes;




import org.springframework.stereotype.Component;

import com.mzzclinica.api_clinica.domain.ValidacaoException;
import com.mzzclinica.api_clinica.domain.consultas.DadosAgendamentoConsulta;
import com.mzzclinica.api_clinica.repository.MedicoRepository;


@Component
public class ValidadorMedicoComConsultaNoHorario implements ValidadorAgendamentoDeConsultas{
    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var medicoPossuiConsultaNoHorario = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());

        if((boolean) medicoPossuiConsultaNoHorario) {
            throw new ValidacaoException("Médico já possui consulta agendada nesse horário");
        }   
    }
}
