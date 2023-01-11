package br.com.attornatus.avtecnica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.attornatus.avtecnica.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
