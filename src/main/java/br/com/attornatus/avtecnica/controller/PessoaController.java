package br.com.attornatus.avtecnica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.avtecnica.controller.dto.DadosCadastroPessoa;
import br.com.attornatus.avtecnica.domain.Pessoa;
import br.com.attornatus.avtecnica.repositories.PessoaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	PessoaRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroPessoa dadosCadastroPessoa) {
			repository.save(new Pessoa(dadosCadastroPessoa));
	}
}