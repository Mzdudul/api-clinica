package com.mzzclinica.api_clinica.domain.consultas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzzclinica.api_clinica.domain.ValidacaoException;
import com.mzzclinica.api_clinica.domain.medico.Medico;
import com.mzzclinica.api_clinica.domain.paciente.PacienteRepository;
import com.mzzclinica.api_clinica.repository.ConsultaRepository;
import com.mzzclinica.api_clinica.repository.MedicoRepository;

@Service
public class AgendamentoConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public void agendarConsulta(DadosAgendamentoConsulta dados) {

        if(!pacienteRepository.existsById(dados.idPaciente())){
            throw new ValidacaoException("Id do paciente informado não existe");
        }

        if(dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())){
            throw new ValidacaoException("Id do médico informado não existe");
        }

        var paciente = pacienteRepository.findById(dados.idPaciente()).get();
        var medico = ecolherMedico(dados);
        var consulta = new Consulta(null, medico, paciente, dados.data());
        consultaRepository.save(consulta);
    }

    private Medico ecolherMedico(DadosAgendamentoConsulta dados) {
        if(dados.idMedico() != null) {
            return medicoRepository.getReferenceById(dados.idMedico());
        }

        if(dados.especialidade() == null) {
            throw new ValidacaoException("Especialidade não informada");
        }
        return medicoRepository.escolherMedicoAleatorioLivreNaData(
                dados.especialidade(), dados.data());
    }
}
