package br.com.attornatus.avtecnica.controller.dto;

import java.time.LocalDate;

import br.com.attornatus.avtecnica.domain.Pessoa;

public record DadosConsultaPessoa(
		String nome,
		LocalDate dataNascimento) {
	
	public DadosConsultaPessoa(Pessoa pessoa) {
		this(pessoa.getNome(), pessoa.getDataNascimento());
	}

}
