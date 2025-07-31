package com.mzzclinica.api_clinica.controller;

import com.mzzclinica.api_clinica.endereco.DadosEndereco;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(
    @NotNull
    Long id, 
    String nome, 
    String telefone, 
    DadosEndereco endereco) {

}
