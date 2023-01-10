package br.com.attornatus.avtecnica.domain;

import br.com.attornatus.avtecnica.controller.dto.DadosCadastroEndereco;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String logradouro;
	private String cep;
	private String numero;
	private String cidade;
	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;

	public Endereco(String logradouro, String cep, String numero, String cidade, Pessoa pessoa) {
		super();
		this.logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade;
		this.pessoa = pessoa;
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
