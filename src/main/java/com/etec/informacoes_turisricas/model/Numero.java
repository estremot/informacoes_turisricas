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
public class Numero {
	
	//-- numero = {codnumero, numero}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codnumero;
	
	@Column
	@Size (min = 2 , max = 80 ) 
	@NotNull(message = "O número deve ter um valor!")
    private String numeroend;

	public Long getCodnumero() {
		return codnumero;
	}

	public void setCodnumero(Long codnumero) {
		this.codnumero = codnumero;
	}

	public String getNumeroend() {
		return numeroend;
	}

	public void setNumeroend(String numeroend) {
		this.numeroend = numeroend;
	}

	public Numero() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Numero(Long codnumero,
			@Size(min = 2, max = 80) @NotNull(message = "O número deve ter um valor!") String numeroend) {
		super();
		this.codnumero = codnumero;
		this.numeroend = numeroend;
	}
	
	
	
}
