package br.com.attornatus.avtecnica.domain;

import br.com.attornatus.avtecnica.controller.dto.DadosCadastroEndereco;
import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {

	private String logradouro;
	private String cep;
	private String numero;
	private String cidade;

	public Endereco(String logradouro, String cep, String numero, String cidade) {
		super();
		this.logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade;
	}

	public Endereco() {
		super();
	}

	public Endereco(DadosCadastroEndereco dadosCadastroEndereco) {
		this.cep = dadosCadastroEndereco.cep();
		this.cidade = dadosCadastroEndereco.cep();
		this.logradouro = dadosCadastroEndereco.logradouro();
		this.numero = dadosCadastroEndereco.numero();
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
