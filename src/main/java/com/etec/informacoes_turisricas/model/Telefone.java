package com.etec.informacoes_turisricas.model;



import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Telefone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codtelefone;
	
	@Column
	private String numero;
	
    @ManyToOne
	@JoinColumn(name = "codestabelecimentofk")
	private Estabelecimento estabelecimento;
    
    
	

	public long getCodtelefone() {
		return codtelefone;
	}




	public void setCodtelefone(long codtelefone) {
		this.codtelefone = codtelefone;
	}




	public String getNumero() {
		return numero;
	}




	public void setNumero(String numero) {
		this.numero = numero;
	}




	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}




	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}




	public Telefone( String numero,  Estabelecimento estabelecimento) {
		super();
		this.numero = numero;
		this.estabelecimento = estabelecimento;

	}
	
    
    

}
