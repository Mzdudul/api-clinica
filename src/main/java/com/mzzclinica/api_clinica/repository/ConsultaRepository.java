package com.mzzclinica.api_clinica.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mzzclinica.api_clinica.domain.consultas.Consulta;


public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    Object existsByPacienteIdAndDataBetween(Long idPaciente, LocalDateTime primeiroHorario,
            LocalDateTime ultimoHorario);

}
