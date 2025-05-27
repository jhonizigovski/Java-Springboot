package com.lp4.viagem.modelo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome deve ser informado")
	@Size(min = 2, message = "O nome deve ter no mínimo 2 caracteres")
	private String nome;
	
	@Min(value = 18, message = "O usuário deve ter no mínimo 18 anos.")
	private int idade;
	
	@NotBlank(message = "O E-mail deve ser informado")
	@Size(min = 2, message = "O E-mail deve ter no mínimo 2 caracteres")
	private String email;
	
	@NotNull(message = "O CPF não pode ser vazio")
	@Size(max = 14, message = "O CPF deve ter no máximo 11 números")
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF inválido. O formato correto é XXX.XXX.XXX-XX")
    private String cpf;
	
	@ManyToMany
	@JoinTable(name = "pessoa_viagem", 
	   joinColumns = @JoinColumn(name = "pessoa_id"), 
	   inverseJoinColumns = @JoinColumn(name = "viagem_id"))
	private List<Viagem> viagens; 
	
	@ManyToOne
	private AgenteDeViagem agenteDeViagem;
	 
	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public List<Viagem> getViagens() {
		return viagens;
	}

	public void setViagens(List<Viagem> viagens) {
		this.viagens = viagens;
	}

	public AgenteDeViagem getAgenteDeViagem() {
		return agenteDeViagem;
	}

	public void setAgenteDeViagem(AgenteDeViagem agenteDeViagem) {
		this.agenteDeViagem = agenteDeViagem;
	}

	

}
