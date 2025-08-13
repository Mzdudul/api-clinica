package com.mzzclinica.api_clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mzzclinica.api_clinica.domain.consultas.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

}
