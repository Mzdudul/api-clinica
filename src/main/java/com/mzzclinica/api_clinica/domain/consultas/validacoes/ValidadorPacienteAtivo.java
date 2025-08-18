package com.mzzclinica.api_clinica.domain.consultas.validacoes;

import org.springframework.stereotype.Component;

import com.mzzclinica.api_clinica.domain.ValidacaoException;
import com.mzzclinica.api_clinica.domain.consultas.DadosAgendamentoConsulta;
import com.mzzclinica.api_clinica.domain.paciente.PacienteRepository;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsultas{

    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());
        if((boolean) pacienteEstaAtivo){
            throw new ValidacaoException("CONSULTA NÃO PODE SER AGENDADDA COM PACIENTE EXCLUIDO");
        }
    }
}
