package com.etec.informacoes_turisricas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cidade {

	//-- cidade = {codcidade, nomecidade, coduffk}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codcidade;
	
	@Column
	@Size (min = 2 , max = 80 ) 
	@NotNull(message = "O nome da cidade deve ter um valor!")
    private String nomecidade;
	
	

	public Long getCodcidade() {
		return codcidade;
	}

	public void setCodcidade(Long codcidade) {
		this.codcidade = codcidade;
	}

	public String getNomecidade() {
		return nomecidade;
	}

	public void setNomecidade(String nomecidade) {
		this.nomecidade = nomecidade;
	}


	public Cidade(Long codcidade,
			@Size(min = 2, max = 80) @NotNull(message = "O nome da cidade deve ter um valor!") String nomecidade) {
		super();
		this.codcidade = codcidade;
		this.nomecidade = nomecidade;
		
	}

	public Cidade() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
