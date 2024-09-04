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
public class Bairro {
	//-- bairro = {codbairro, nomebairro}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codbairro;
	
	@Column
	@Size (min = 2 , max = 80 ) 
	@NotNull(message = "O nome do bairro deve ter um valor!")
    private String nomebairro;

	public Long getCodbairro() {
		return codbairro;
	}

	public void setCodbairro(Long codbairro) {
		this.codbairro = codbairro;
	}

	public String getNomebairro() {
		return nomebairro;
	}

	public void setNomebairro(String nomebairro) {
		this.nomebairro = nomebairro;
	}

	public Bairro(Long codbairro,
			@Size(min = 2, max = 80) @NotNull(message = "O nome do bairro deve ter um valor!") String nomebairro) {
		super();
		this.codbairro = codbairro;
		this.nomebairro = nomebairro;
	}

	public Bairro() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
