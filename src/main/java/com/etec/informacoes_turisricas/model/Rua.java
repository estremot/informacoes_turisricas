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
public class Rua {

	//-- rua = {codrua, nomerua}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codrua;
	
	@Column
	@Size (min = 2 , max = 80 ) 
	@NotNull(message = "O nome da rua deve ter um valor!")
    private String nomerua;

	public Long getCodrua() {
		return codrua;
	}

	public void setCodrua(Long codrua) {
		this.codrua = codrua;
	}

	public String getNomerua() {
		return nomerua;
	}

	public void setNomerua(String nomerua) {
		this.nomerua = nomerua;
	}

	public Rua(Long codrua,
			@Size(min = 2, max = 80) @NotNull(message = "O nome da rua deve ter um valor!") String nomerua) {
		super();
		this.codrua = codrua;
		this.nomerua = nomerua;
	}

	public Rua() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
