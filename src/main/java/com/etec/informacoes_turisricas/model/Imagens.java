package com.etec.informacoes_turisricas.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Imagens {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codimagem;
	
	@Column
	private String nomeimagem;
	
	@Column
    private Date dataimagem;
	@Column
	private String descricao;
	//@Lob   //representa um campo do tipo blob no bd
	@Column
	private byte[] foto;
	
	public Imagens( String nomeimagem, Date dataimagem, String descricao,  Estabelecimento estabelecimento) {
		super();
		this.dataimagem = dataimagem;
		this.descricao = descricao;
		this.nomeimagem = nomeimagem;
		//this.foto = foto;
		this.estabelecimento = estabelecimento;
	}

	@ManyToOne
	@JoinColumn(name = "codestabelecimentofk")
	private Estabelecimento estabelecimento;

	public Long getCodimagem() {
		return codimagem;
	}

	public void setCodimagem(Long codimagem) {
		this.codimagem = codimagem;
	}

	public Date getDataimagem() {
		return dataimagem;
	}

	public void setDataimagem(Date dataimagem) {
		this.dataimagem = dataimagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}



	public String getNomeimagem() {
		return nomeimagem;
	}

	public void setNomeimagem(String nomeimagem) {
		this.nomeimagem = nomeimagem;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Imagens() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Imagens(String nomeimagem, Date dataimagem, String descricao, byte[] foto, Estabelecimento estabelecimento) {
		super();
		this.nomeimagem = nomeimagem;
		this.dataimagem = dataimagem;
		this.descricao = descricao;
		this.foto = foto;
		this.estabelecimento = estabelecimento;
	}
	
	
	
	
}
