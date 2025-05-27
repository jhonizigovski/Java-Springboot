package com.lp4.viagem.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lp4.viagem.modelo.Viagem;
import com.lp4.viagem.repositorio.ViagemRepositorio;

@Service
public class ViagemServico {
	
	@Autowired
	private ViagemRepositorio viagemRepositorio;
	
	public Viagem criarViagem(Viagem viagem) {
		return viagemRepositorio.save(viagem);
	}
	
	//Método para listar as pessoas cadastradas
		public List<Viagem> buscarTodasViagens(){
			return viagemRepositorio.findAll();
		}

}
 