package com.lp4.viagem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lp4.viagem.modelo.Viagem;
import com.lp4.viagem.servico.ViagemServico;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/viagem")
public class ViagemController {
	
	@Autowired
	private ViagemServico viagemServico;
	
	//cadastrando uma nova viagem
	@GetMapping("/novo")
	public String novaViagem(Model model) {
		Viagem viagem = new Viagem();
		model.addAttribute("novaViagem", viagem);
		return "/nova-viagem";
	}
	
	//gravando uma nova viagem
	@PostMapping("/gravar")
	public String gravarViagem(@ModelAttribute("novaViagem") @Valid Viagem viagem, //validando pessoa
			BindingResult erros, //acomodando os erros no objeto erros
			RedirectAttributes attributes) {
		if(erros.hasErrors()) {
			return "/nova-viagem";
		} 
		viagemServico.criarViagem(viagem);
		attributes.addFlashAttribute("mensagem", "Viagem salvo com Sucesso");
		return "redirect:/";
	}

}
