package com.mzzclinica.api_clinica.controller;

import com.mzzclinica.api_clinica.endereco.DadosEndereco;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(
    @NotNull
    Long id, 
    String nome, 
    String telefone, 
    DadosEndereco endereco) {

        public DadosAtualizacaoMedico(@NotNull Long id, String nome, String telefone, DadosEndereco endereco) {
            this.id = id;
            this.nome = nome;
            this.telefone = telefone;
            this.endereco = endereco;
        }

}
