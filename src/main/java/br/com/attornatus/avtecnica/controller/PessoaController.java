package br.com.attornatus.avtecnica.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.avtecnica.controller.dto.DadosCadastroEndereco;
import br.com.attornatus.avtecnica.controller.dto.DadosCadastroPessoa;
import br.com.attornatus.avtecnica.controller.dto.DadosConsultaPessoa;
import br.com.attornatus.avtecnica.controller.dto.DadosEditarPessoa;
import br.com.attornatus.avtecnica.domain.Endereco;
import br.com.attornatus.avtecnica.domain.Pessoa;
import br.com.attornatus.avtecnica.repositories.EnderecoRepository;
import br.com.attornatus.avtecnica.repositories.PessoaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	PessoaRepository pessoaRepository;
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroPessoa dadosCadastroPessoa) {
		Pessoa pessoa = new Pessoa(dadosCadastroPessoa);
		pessoaRepository.save(pessoa);
		Endereco endereco = new Endereco(dadosCadastroPessoa.endereco());
		endereco.setPessoa(pessoa);
		enderecoRepository.save(endereco);
	}
	
	@PutMapping
	@Transactional
	public void editar(@RequestBody @Valid DadosEditarPessoa dadosEditarPessoa) {
		var pessoa = pessoaRepository.getReferenceById(dadosEditarPessoa.id());
		pessoa.atualizarDados(dadosEditarPessoa);
	}
	
	@GetMapping("/{id}")
	public DadosConsultaPessoa consultarPessoa(@PathVariable Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		DadosConsultaPessoa dtoDadosContultaUmaPessoa = pessoa.get().toDtoDadosContultaUmaPessoa();
		return dtoDadosContultaUmaPessoa;
	}
	
	@GetMapping
	public Page<DadosConsultaPessoa> listarPessoas(@PageableDefault(size=10, sort = {"nome"}) Pageable paginacao){
		return pessoaRepository.findAll(paginacao).map(DadosConsultaPessoa::new);
	}
	
	@PostMapping("/{idPessoa}/endereco")
	@Transactional
	public void cadastrarEndereco(@PathVariable Long idPessoa, @RequestBody DadosCadastroEndereco dadosCadastroEndereco) {
		Endereco endereco = new Endereco(dadosCadastroEndereco);
		Pessoa pessoa = pessoaRepository.getReferenceById(idPessoa);
		endereco.setPessoa(pessoa);
		enderecoRepository.save(endereco);
	}
}
