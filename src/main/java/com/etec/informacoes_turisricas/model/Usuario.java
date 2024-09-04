package com.etec.informacoes_turisricas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Usuario {
	//-- uf = {coduf, nomeuf, sigla}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codusuario;
	
	@Column
	@NotNull(message = "O Nome UF deve ter um valor!")
    private String nomeusuario;
	
	@Column
	@NotNull(message = "A Sigla deve ter um valor!")
    private String senha;

	@Column
	@NotNull(message = "O email deve ter um valor!")
    private String email;
	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCodusuario() {
		return codusuario;
	}

	public void setCodusuario(Long codusuario) {
		this.codusuario = codusuario;
	}

	public String getNomeusuario() {
		return nomeusuario;
	}

	public void setNomeusuario(String nomeusuario) {
		this.nomeusuario = nomeusuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario(Long codusuario, String nomeusuario, String senha, String email) {
		super();
		this.codusuario = codusuario;
		this.nomeusuario = nomeusuario;
		this.senha = senha;
		this.email = email;
	}

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
