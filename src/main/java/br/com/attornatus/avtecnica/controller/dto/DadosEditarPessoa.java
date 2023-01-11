package br.com.attornatus.avtecnica.controller.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public record DadosEditarPessoa(
		@NotNull
		Long id,
		String nome,
		LocalDate dataNascimento) {

}
