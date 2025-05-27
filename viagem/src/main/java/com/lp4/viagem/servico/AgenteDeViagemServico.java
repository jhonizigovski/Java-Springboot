package com.lp4.viagem.servico;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp4.viagem.modelo.AgenteDeViagem;
import com.lp4.viagem.repositorio.AgenteDeViagemRepositorio;

@Service
public class AgenteDeViagemServico {
	
	@Autowired
	private AgenteDeViagemRepositorio agenteDeViagemRepositorio;
	
	//Método para salvar um novo agente
	public AgenteDeViagem gravar(AgenteDeViagem agenteDeViagem) {
		return agenteDeViagemRepositorio.save(agenteDeViagem);
	}
	
	public List<AgenteDeViagem> listarAgente(){
		return agenteDeViagemRepositorio.findAll();
	}

} 
