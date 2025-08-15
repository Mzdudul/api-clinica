package com.mzzclinica.api_clinica.domain.consultas.validacoes;



import com.mzzclinica.api_clinica.domain.ValidacaoException;
import com.mzzclinica.api_clinica.domain.consultas.DadosAgendamentoConsulta;
import com.mzzclinica.api_clinica.repository.MedicoRepository;



public class ValidadorMedicoComConsultaNoHorario {
    private MedicoRepository repository;

    public void validarMedicoComConsultaNoHorario(DadosAgendamentoConsulta dados) {
        var medicoPossuiConsultaNoHorario = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());

        if((boolean) medicoPossuiConsultaNoHorario) {
            throw new ValidacaoException("Médico já possui consulta agendada nesse horário");
        }   
    }
}
