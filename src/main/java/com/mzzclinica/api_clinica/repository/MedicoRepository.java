package com.mzzclinica.api_clinica.repository;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mzzclinica.api_clinica.domain.medico.Especialidade;
import com.mzzclinica.api_clinica.domain.medico.Medico;



public interface MedicoRepository extends JpaRepository<Medico, Long> {

    Page<Medico> findAllByAtivoTrue(Pageable paginacao);

     @Query("SELECT m FROM Medico m WHERE m.especialidade = :especialidade ORDER BY RAND() limit 1 AND m.ativo = true AND m.id NOT IN (SELECT c.medico.id FROM Consulta c WHERE c.data = :data)")
    Medico escolherMedicoAleatorioLivreNaData(Especialidade especialidade, LocalDateTime data);


    @Query("SELECT m.ativo FROM Medico m WHERE m.id = :id")
     Object findAtivoById(Long idMedico);


    
    Object existsByMedicoIdAndData(Long idMedico, LocalDateTime data);
    
}
