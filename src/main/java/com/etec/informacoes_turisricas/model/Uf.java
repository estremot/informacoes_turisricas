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
public class Uf {
	//-- uf = {coduf, nomeuf, sigla}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long coduf;
	
	@Column
	@Size (min = 2 , max = 80 ) 
	@NotNull(message = "O Nome UF deve ter um valor!")
    private String nomeuf;
	
	@Column
	@Size (min = 2 , max =2 ) 
	@NotNull(message = "A Sigla deve ter um valor!")
    private String sigla;

	public Long getCoduf() {
		return coduf;
	}

	public void setCoduf(Long coduf) {
		this.coduf = coduf;
	}

	public String getNomeuf() {
		return nomeuf;
	}

	public void setNomeuf(String nomeuf) {
		this.nomeuf = nomeuf;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Uf(Long coduf, @Size(min = 2, max = 80) @NotNull(message = "O Nome UF deve ter um valor!") String nomeuf,
			@Size(min = 2, max = 2) @NotNull(message = "A Sigla deve ter um valor!") String sigla) {
		super();
		this.coduf = coduf;
		this.nomeuf = nomeuf;
		this.sigla = sigla;
	}

	public Uf() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
