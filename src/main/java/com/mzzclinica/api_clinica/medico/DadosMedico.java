package com.mzzclinica.api_clinica.medico;

import com.mzzclinica.api_clinica.endereco.DadosEndereco;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public record DadosMedico(
    
    @NotBlank
    String nome,
    
    @NotBlank    
    @Email
    String email, 
    
    @NotBlank
    @Pattern(regexp = "\\d{4,6}")
    String crm,

    @NotBlank
    String telefone,
    
    @NotNull
    Especialidade especialidade, 
    
    @NotNull @Valid DadosEndereco endereco) {
    
   
    
}
