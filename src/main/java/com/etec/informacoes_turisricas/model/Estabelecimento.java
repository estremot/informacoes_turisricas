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
public class Estabelecimento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codestabelecimento;
	
	@Column
	private String nomefantasia;
	@Column
	private String razaosocial;
	@Column
    private Date datacriacao;
	
    @ManyToOne
	@JoinColumn(name = "codruafk")
	private Rua rua;
    
    @ManyToOne
	@JoinColumn(name = "codnumerofk")
	private Numero numero;
	
    @ManyToOne
	@JoinColumn(name = "codbairrofk")
	private Bairro bairro;
    
    @ManyToOne
	@JoinColumn(name = "codcepfk")
	private Cep cep;
	
    @ManyToOne
	@JoinColumn(name = "codcidadefk")
	private Cidade cidade;
	
    @ManyToOne
	@JoinColumn(name = "coduffk")
	private Uf uf;

	public long getCodestabelecimento() {
		return codestabelecimento;
	}

	public void setCodestabelecimento(long codestabelecimento) {
		this.codestabelecimento = codestabelecimento;
	}

	public String getNome_fantasia() {
		return nomefantasia;
	}

	public void setNomefantasia(String nomefantasia) {
		this.nomefantasia = nomefantasia;
	}

	public String getRazaosocial() {
		return razaosocial;
	}

	public void setRazaosocial(String razaosocial) {
		this.razaosocial = razaosocial;
	}

	public Date getDatacriacao() {
		return datacriacao;
	}

	public void setDatacriacao(Date datacriacao) {
		this.datacriacao = datacriacao;
	}

	public Rua getRua() {
		return rua;
	}

	public void setRua(Rua rua) {
		this.rua = rua;
	}

	public Numero getNumero() {
		return numero;
	}

	public void setNumero(Numero numero) {
		this.numero = numero;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public Cep getCep() {
		return cep;
	}

	public void setCep(Cep cep) {
		this.cep = cep;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

	public Estabelecimento( String nomefantasia, String razaosocial, Date datacriacao,
			Rua rua, Numero numero, Bairro bairro, Cep cep, Cidade cidade, Uf uf) {
		super();
		this.nomefantasia = nomefantasia;
		this.razaosocial = razaosocial;
		this.datacriacao = datacriacao;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
	}
	
    
    

}
