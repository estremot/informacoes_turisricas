package com.etec.informacoes_turisricas.controle.form;

import java.util.Date;

import com.etec.informacoes_turisricas.model.Estabelecimento;
import com.etec.informacoes_turisricas.model.Imagens;
import com.etec.informacoes_turisricas.repository.R_Estabelecimento;
import com.etec.informacoes_turisricas.repository.R_Imagens;


public class ImagensForm {

	private Long codimagem;
	private String nomeimagem;
	private Date dataimagem;
	private String descricao;
	private byte[] foto;
	private Long codestabelecimento;


	public String getNomeimagem() {
		return nomeimagem;
	}

	public void setNomeimagem(String nomeimagem) {
		this.nomeimagem = nomeimagem;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Long getCodimagem() {
		return codimagem;
	}

	public void setCodimagem(Long codimagem) {
		this.codimagem = codimagem;
	}

	public Date getDataimagem() {
		return dataimagem;
	}

	public void setDataimagem(java.sql.Date dataimagem) {
		this.dataimagem = dataimagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getCodestabelecimento() {
		return codestabelecimento;
	}

	public void setCodestabelecimento(Long codestabelecimento) {
		this.codestabelecimento = codestabelecimento;
	}

	public Imagens converter(R_Estabelecimento re) {
		// TODO Auto-generated method stub
		System.out.println("Converter 1");
		Estabelecimento estabelecimento = re.getOne(codestabelecimento);

		return new Imagens(nomeimagem, dataimagem, descricao, estabelecimento);

	}

	public Imagens atualizar(Long codimagem, R_Estabelecimento re, R_Imagens ri) {
		// TODO Auto-generated method stub

		
		  Estabelecimento estabelecimento = re.getOne(codestabelecimento); 
		  
		  Imagens imagem = ri.getOne(codimagem);
		  
		  imagem.setEstabelecimento(estabelecimento); 
		  imagem.setDataimagem(dataimagem);
		  imagem.setDescricao(descricao);
		  imagem.setFoto(foto);
		  imagem.setNomeimagem(nomeimagem);
		  
		  
		 return imagem;
		 
	}
}
