package br.com.attornatus.avtecnica.controller.dto;

import java.time.LocalDate;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPessoa(
		@NotBlank
		String nome,
		@NotNull
		LocalDate dataNascimento,
		@Valid
		DadosCadastroEndereco endereco) {

}
