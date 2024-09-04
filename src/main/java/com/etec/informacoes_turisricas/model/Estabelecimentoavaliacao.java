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
public class Estabelecimentoavaliacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codestabelecimentoavaliacao;
	
	@Column
	private String cometario;
	@Column
	private Double pontuacao;
	
	
    @ManyToOne
	@JoinColumn(name = "codavaliacao")
	private Avaliacao avaliacao;
    
    @ManyToOne
	@JoinColumn(name = "codestabelecimentofk")
	private Estabelecimento estabelecimento;
	
    
   
		public long getCodestabelecimentoavaliacao() {
		return codestabelecimentoavaliacao;
	}



	public void setCodestabelecimentoavaliacao(long codestabelecimentoavaliacao) {
		this.codestabelecimentoavaliacao = codestabelecimentoavaliacao;
	}



	public String getCometario() {
		return cometario;
	}



	public void setCometario(String cometario) {
		this.cometario = cometario;
	}



	public Double getPontuacao() {
		return pontuacao;
	}



	public void setPontuacao(Double pontuacao) {
		this.pontuacao = pontuacao;
	}



	public Avaliacao getAvaliacao() {
		return avaliacao;
	}



	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}



	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}



	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}



	public Estabelecimentoavaliacao(String cometario, Double pontuacao, Avaliacao avaliacao,
			Estabelecimento estabelecimento) {
		super();
		this.cometario = cometario;
		this.pontuacao = pontuacao;
		this.avaliacao = avaliacao;
		this.estabelecimento = estabelecimento;
	}



	
    
    

}
