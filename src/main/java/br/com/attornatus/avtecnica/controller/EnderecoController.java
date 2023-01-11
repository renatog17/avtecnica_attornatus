package br.com.attornatus.avtecnica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.attornatus.avtecnica.controller.dto.DadosCadastroEndereco;
import br.com.attornatus.avtecnica.domain.Endereco;
import br.com.attornatus.avtecnica.domain.Pessoa;
import br.com.attornatus.avtecnica.repositories.EnderecoRepository;
import br.com.attornatus.avtecnica.repositories.PessoaRepository;

@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	PessoaRepository pessoaRepository;
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@PostMapping("/{idPessoa}")
	public void cadastrarEndereco(@PathVariable Long idPessoa, @RequestBody DadosCadastroEndereco dadosCadastroEndereco) {
		Endereco endereco = new Endereco(dadosCadastroEndereco);
		Pessoa pessoa = new Pessoa();
		pessoa.setId(idPessoa);
		endereco.setPessoa(pessoa);
	}
}
