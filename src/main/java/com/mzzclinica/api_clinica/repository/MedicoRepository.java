package com.mzzclinica.api_clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mzzclinica.api_clinica.medico.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    
}
