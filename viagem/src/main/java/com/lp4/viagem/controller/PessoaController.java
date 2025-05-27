package com.lp4.viagem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lp4.viagem.excecao.PessoaNotFoundException;
import com.lp4.viagem.modelo.AgenteDeViagem;
import com.lp4.viagem.modelo.Pessoa;
import com.lp4.viagem.modelo.Viagem;
import com.lp4.viagem.servico.AgenteDeViagemServico;
import com.lp4.viagem.servico.PessoaServico;
import com.lp4.viagem.servico.ViagemServico;

import jakarta.validation.Valid;

@Controller
public class PessoaController {
	
	@Autowired
	private PessoaServico pessoaServico;
	
	@Autowired
	private ViagemServico viagemServico;
	
	@Autowired
	private AgenteDeViagemServico agenteDeViagemServico;
	
	//listando pessoas cadastradas
	@GetMapping("/")
	public String listarPessoas(Model model){
		List<Pessoa> pessoas = pessoaServico.buscarTodasPessoas();
		model.addAttribute("listaPessoas", pessoas);
		return "/lista-pessoas";
	}
	
	//buscando pessoa pela barra de pesquisa
	@PostMapping("/buscar")
	public String buscarPessoa(@Param("nome") String nome, Model model) {
		if (nome == null) {
			return "redirect:/";
		}
		List<Pessoa> pessoas = pessoaServico.buscarPessoaPorNome(nome);
		model.addAttribute("listaPessoas", pessoas);
		return "/lista-pessoas";
	}
	
	//cadastrando nova pessoa
	@GetMapping("/novo")
	public String novaPessoa(Model model) {
		Pessoa pessoa = new Pessoa();
		model.addAttribute("novaPessoa", pessoa);
		
		List<Viagem> viagens = viagemServico.buscarTodasViagens();
		model.addAttribute("todasViagens", viagens);
		
		List<AgenteDeViagem> agenteDeViagens = agenteDeViagemServico.listarAgente();
		model.addAttribute("todosAgentes", agenteDeViagens);
		
		return "/nova-pessoa";
	}
	
	//gravando nova pessoa
	@PostMapping("/gravar")
	public String gravarPessoa(@ModelAttribute("novaPessoa") @Valid Pessoa pessoa, //validando pessoa
			BindingResult erros, //acomodando os erros no objeto erros
			RedirectAttributes attributes, Model model) {
		if(erros.hasErrors()) {
			
			List<Viagem> viagens = viagemServico.buscarTodasViagens();
			model.addAttribute("todasViagens", viagens);
			
			List<AgenteDeViagem> agenteDeViagens = agenteDeViagemServico.listarAgente();
			model.addAttribute("todosAgentes", agenteDeViagens);
			
			return "/nova-pessoa";
		}
		pessoaServico.criarPessoa(pessoa);
		attributes.addFlashAttribute("mensagem", "Cliente salvo com Sucesso");
		return "redirect:/";
	} 
	
	//apagando pessoa pelo ID
	@GetMapping("/apagar/{id}")
	public String apagarPessoa(@PathVariable("id") long id, RedirectAttributes attributes) {
		try {
			pessoaServico.apagarPessoa(id);
		} catch (PessoaNotFoundException e) {
			attributes.addFlashAttribute("mensagemErro", e.getMessage());
		}
		return "redirect:/";
	}
	
	//buscnado pessoa para editar pelo ID
	@GetMapping("/editar/{id}")
	public String editarForm(@PathVariable("id") long id, RedirectAttributes attributes, Model model) {
		try {
			Pessoa pessoa = pessoaServico.buscarPessoaPorId(id);	
			model.addAttribute("objetoPessoa", pessoa);
			
			List<Viagem> viagens = viagemServico.buscarTodasViagens();
			model.addAttribute("todasViagens", viagens);
			
			List<AgenteDeViagem> agenteDeViagens = agenteDeViagemServico.listarAgente();
			model.addAttribute("todosAgentes", agenteDeViagens);
			
			return "/alterar-pessoa";
		} catch (PessoaNotFoundException e) {
			attributes.addFlashAttribute("mensagemErro", e.getMessage());
		}
		return "redirect:/";
	}
	
	//editando cadastro da pessoa pelo ID
	@PostMapping("/editar/{id}")
	public String editarPessoa(@PathVariable("id") long id, Model model,
			@ModelAttribute("objetoPessoa") @Valid Pessoa pessoa, BindingResult erros,
			RedirectAttributes attributes) {
		if(erros.hasErrors()) {
			pessoa.setId(id);
			
			List<Viagem> viagens = viagemServico.buscarTodasViagens();
			model.addAttribute("todasViagens", viagens);
			
			List<AgenteDeViagem> agenteDeViagens = agenteDeViagemServico.listarAgente();
			model.addAttribute("todosAgentes", agenteDeViagens);
			
			return "/alterar-pessoa";
		}
		pessoaServico.alterarPessoa(pessoa);
		attributes.addFlashAttribute("mensagem", "Dados alterados com Sucesso");
		return "redirect:/";
	}
	
	//visualizando os dados de uma pessoa cadastrada pelo ID
	@GetMapping("/ver/{id}")
	public String verForm(@PathVariable("id") long id, RedirectAttributes attributes, Model model) {
		try {
			Pessoa pessoa = pessoaServico.buscarPessoaPorId(id);	
			model.addAttribute("objetoPessoa", pessoa);
			
			return "/ver-pessoa";
		} catch (PessoaNotFoundException e) {
			attributes.addFlashAttribute("mensagemErro", e.getMessage());
		}
		return "redirect:/";
	}
	
}


