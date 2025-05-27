package com.lp4.viagem.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp4.viagem.excecao.PessoaNotFoundException;
import com.lp4.viagem.modelo.Pessoa;
import com.lp4.viagem.repositorio.PessoaRepositorio;

@Service
public class PessoaServico {
	
	@Autowired
	private PessoaRepositorio pessoaRepositorio;
	
	//Método para salvar uma nova pessoa
	public Pessoa criarPessoa(Pessoa pessoa) {
		return pessoaRepositorio.save(pessoa);
	}
	
	//Método para listar as pessoas cadastradas
	public List<Pessoa> buscarTodasPessoas(){
		return pessoaRepositorio.findAll();
	}
	
	//Método para buscar pessoa pelo ID
	public Pessoa buscarPessoaPorId(long id)throws PessoaNotFoundException {
		Optional<Pessoa> opt = pessoaRepositorio.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}else {
			throw new PessoaNotFoundException("Pessoa com id: " + id + " não existe.");
		} 
	}
	
	//Método para apagar pessoa
	public void apagarPessoa(long id) throws PessoaNotFoundException{
		Pessoa pessoa = buscarPessoaPorId(id);
		pessoaRepositorio.delete(pessoa);
	}
	
	//Método para alterar dados de uma pessoa
	public Pessoa alterarPessoa(Pessoa pessoa) {
		return pessoaRepositorio.save(pessoa);
	}
	
	//Método de busca por nome
	public List<Pessoa> buscarPessoaPorNome(String nome) {
		return pessoaRepositorio.findByNomeContainingIgnoreCase(nome);
	}
		
	
}
