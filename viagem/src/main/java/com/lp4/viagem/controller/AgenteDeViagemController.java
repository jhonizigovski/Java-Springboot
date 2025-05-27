package com.lp4.viagem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lp4.viagem.modelo.AgenteDeViagem;
import com.lp4.viagem.servico.AgenteDeViagemServico;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/agente-de-viagem")
public class AgenteDeViagemController {
	
	@Autowired
	private AgenteDeViagemServico agenteDeViagemServico;
	
	//cadastrando novo agente de viagem
	@GetMapping("/novo")
	public String novoAgenteDeViagem(Model model) {
		AgenteDeViagem agenteDeViagem = new AgenteDeViagem();
		model.addAttribute("novoAgenteDeViagem", agenteDeViagem);
		return "/novo-agente-de-viagem";
	}
	
	//gravando novo agente de viagem
		@PostMapping("/gravar")
		public String gravarAgenteDeViagem(@ModelAttribute("novoAgenteDeViagem") @Valid AgenteDeViagem agenteDeViagem, //validando agente
				BindingResult erros, //acomodando os erros no objeto erros
				RedirectAttributes attributes, Model model) {
			if(erros.hasErrors()) {
				return "/novo-agente-de-viagem";
			}
			agenteDeViagemServico.gravar(agenteDeViagem);
			attributes.addFlashAttribute("mensagem", "Agente de viagem salvo com Sucesso");
			return "redirect:/";
		}
 
}
