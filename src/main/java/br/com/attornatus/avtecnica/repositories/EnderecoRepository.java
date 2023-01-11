package br.com.attornatus.avtecnica.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.attornatus.avtecnica.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

	List<Endereco> findAllByPessoaId(Long id);
	
	Endereco findByPessoaIdAndId(Long idPessoa, Long idEndereco);
}
