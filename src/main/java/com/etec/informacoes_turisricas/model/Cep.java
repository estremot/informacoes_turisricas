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
public class Cep {

	//-- cep = {codcep, nomecep}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codcep;
	
	@Column
	@Size (min = 9 , max = 9 ) 
	@NotNull(message = "O número do cep deve ter um valor!")
    private String numerocep;

	public Long getCodcep() {
		return codcep;
	}

	public void setCodcep(Long codcep) {
		this.codcep = codcep;
	}

	
	
	public String getNumerocep() {
		return numerocep;
	}

	public void setNumerocep(String numerocep) {
		this.numerocep = numerocep;
	}

	public Cep(Long codcep,
			@Size(min = 9, max = 9) @NotNull(message = "O número do cep deve ter um valor!") String numerocep) {
		super();
		this.codcep = codcep;
		this.numerocep = numerocep;
	}

	public Cep() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
