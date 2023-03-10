package br.com.attornatus.avtecnica.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroEndereco(
		@NotBlank
		String logradouro,
		@NotBlank
		@Pattern(regexp = "\\d{8}")
		String cep,
		@NotBlank
		String numero,
		@NotBlank
		String cidade) {

}
