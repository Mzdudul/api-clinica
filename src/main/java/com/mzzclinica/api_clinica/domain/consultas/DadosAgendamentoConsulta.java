package com.mzzclinica.api_clinica.domain.consultas;

import java.time.LocalDateTime;

import com.mzzclinica.api_clinica.domain.medico.Especialidade;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public record DadosAgendamentoConsulta(

        Long idMedico,
        
        @NotNull 
        Long idPaciente,

        @NotNull
        @Future 
        LocalDateTime data,
        
        Especialidade especialidade
        ) {

}
