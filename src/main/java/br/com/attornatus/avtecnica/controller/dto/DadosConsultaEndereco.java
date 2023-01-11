package br.com.attornatus.avtecnica.controller.dto;

import br.com.attornatus.avtecnica.domain.Endereco;

public record DadosConsultaEndereco(
		String logradouro,
		String cep,
		String numero,
		String cidade) {
	public DadosConsultaEndereco(Endereco endereco) {
		this(endereco.getLogradouro(), endereco.getCep(), endereco.getNumero(), endereco.getCidade());
	}

}
