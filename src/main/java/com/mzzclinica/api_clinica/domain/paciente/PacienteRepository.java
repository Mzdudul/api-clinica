package com.mzzclinica.api_clinica.domain.paciente;

import org.springframework.data.jpa.repository.JpaRepository;



public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Object findAtivoById(Long idPaciente);
    
}
