package com.mzzclinica.api_clinica.domain.paciente;

import com.mzzclinica.api_clinica.domain.endereco.DadosEndereco;

public record DadosCadastroPaciente(String nome, String email, String telefone, String cpf, DadosEndereco endereco) {


}
