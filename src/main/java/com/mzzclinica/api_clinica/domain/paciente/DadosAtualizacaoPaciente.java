package com.mzzclinica.api_clinica.domain.paciente;

import com.mzzclinica.api_clinica.domain.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(String nome, String telefone, DadosEndereco endereco) {


}
