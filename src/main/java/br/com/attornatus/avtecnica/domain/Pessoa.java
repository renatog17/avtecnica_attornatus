package br.com.attornatus.avtecnica.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.attornatus.avtecnica.controller.dto.DadosCadastroPessoa;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private LocalDate dataNascimento;
	@OneToMany(mappedBy = "pessoa")
	private List<Endereco> enderecos = new ArrayList<>();

	public Pessoa(String nome, LocalDate dataNascimento, List<Endereco> enderecos) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.enderecos = enderecos;
	}

	public Pessoa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pessoa(DadosCadastroPessoa dadosCadastroPessoa) {
		this.nome = dadosCadastroPessoa.nome();
		this.dataNascimento = dadosCadastroPessoa.dataNascimento();
		this.enderecos.add(new Endereco(dadosCadastroPessoa.endereco()));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

}
