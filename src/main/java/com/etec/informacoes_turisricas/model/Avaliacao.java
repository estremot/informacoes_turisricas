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
public class Avaliacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codavaliacao;
	
	@Column
	private Date dataavaliacao;
	
	
	
    @ManyToOne
	@JoinColumn(name = "codusuariofk")
	private Usuario usuario;
    
    
    
    
	public long getCodavaliacao() {
		return codavaliacao;
	}




	public void setCodavaliacao(long codavaliacao) {
		this.codavaliacao = codavaliacao;
	}




	public Date getDataavaliacao() {
		return dataavaliacao;
	}




	public void setDataavaliacao(Date dataavaliacao) {
		this.dataavaliacao = dataavaliacao;
	}




	public Usuario getUsuario() {
		return usuario;
	}




	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}




	public Avaliacao( Date dataavaliacao,  Usuario usuario) {
		super();
		this.dataavaliacao = dataavaliacao;
		this.usuario = usuario;
		
	}
	
    
    

}
