package br.com.attornatus.avtecnica.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.attornatus.avtecnica.controller.dto.DadosCadastroPessoa;
import br.com.attornatus.avtecnica.controller.dto.DadosConsultaPessoa;
import br.com.attornatus.avtecnica.controller.dto.DadosEditarPessoa;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Pessoa implements Serializable{

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

	public void atualizarDados(DadosEditarPessoa dadosEditarPessoa) {
		if(dadosEditarPessoa.dataNascimento() != null) {
			this.dataNascimento = dadosEditarPessoa.dataNascimento();
		}
		if(dadosEditarPessoa.nome() != null) {
			this.nome = dadosEditarPessoa.nome();
		}
	}
	
	public DadosConsultaPessoa toDtoDadosContultaUmaPessoa() {
		DadosConsultaPessoa dadosConsultaUmaPessoa = new DadosConsultaPessoa(nome, dataNascimento);
		return dadosConsultaUmaPessoa;
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
