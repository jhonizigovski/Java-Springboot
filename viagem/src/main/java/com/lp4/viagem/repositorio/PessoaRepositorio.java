package com.lp4.viagem.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lp4.viagem.modelo.Pessoa;

public interface PessoaRepositorio extends JpaRepository<Pessoa, Long> {
	List<Pessoa> findByNomeContainingIgnoreCase(String nome);
}
 