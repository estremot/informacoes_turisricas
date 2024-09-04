package com.etec.informacoes_turisricas.controle.form;

import java.sql.Date;

import com.etec.informacoes_turisricas.model.Avaliacao;
import com.etec.informacoes_turisricas.model.Bairro;
import com.etec.informacoes_turisricas.model.Cep;
import com.etec.informacoes_turisricas.model.Cidade;
import com.etec.informacoes_turisricas.model.Estabelecimento;
import com.etec.informacoes_turisricas.model.Estabelecimentoavaliacao;
import com.etec.informacoes_turisricas.model.Numero;
import com.etec.informacoes_turisricas.model.Rua;
import com.etec.informacoes_turisricas.model.Uf;
import com.etec.informacoes_turisricas.repository.R_Avaliacao;
import com.etec.informacoes_turisricas.repository.R_Bairro;
import com.etec.informacoes_turisricas.repository.R_Cep;
import com.etec.informacoes_turisricas.repository.R_Cidade;
import com.etec.informacoes_turisricas.repository.R_Estabelecimento;
import com.etec.informacoes_turisricas.repository.R_Estabelecimentoavaliacao;
import com.etec.informacoes_turisricas.repository.R_Numero;
import com.etec.informacoes_turisricas.repository.R_Rua;
import com.etec.informacoes_turisricas.repository.R_Uf;



public class EstabelecimentoavaliacaoForm {
	private Long codestabelecimentoavaliacao;
	private Long codestabelecimento;
	private Long codavaliacao;
	private String comentario;
    private Double pontuacao;
     
  
public Long getCodestabelecimentoavaliacao() {
		return codestabelecimentoavaliacao;
	}

	public void setCodestabelecimentoavaliacao(Long codestabelecimentoavaliacao) {
		this.codestabelecimentoavaliacao = codestabelecimentoavaliacao;
	}

	public Long getCodestabelecimento() {
		return codestabelecimento;
	}

	public void setCodestabelecimento(Long codestabelecimento) {
		this.codestabelecimento = codestabelecimento;
	}

	public Long getCodavaliacao() {
		return codavaliacao;
	}

	public void setCodavaliacao(Long codavaliacao) {
		this.codavaliacao = codavaliacao;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Double getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Double pontuacao) {
		this.pontuacao = pontuacao;
	}

public Estabelecimentoavaliacao converter(R_Estabelecimento re, R_Avaliacao ra) {
	
	Estabelecimento estabelecimento = re.findByCodestabelecimento(codestabelecimento);
	Avaliacao avaliacao = ra.findByCodavaliacao(codavaliacao);
	   

	return new Estabelecimentoavaliacao(comentario, pontuacao, avaliacao, estabelecimento);

}

public Estabelecimentoavaliacao atualizar(Long codestabelecimentoavaliacao, R_Estabelecimento re, R_Avaliacao ra, R_Estabelecimentoavaliacao rea ) {
	// TODO Auto-generated method stub

	
	  Estabelecimento estabelecimento = re.findByCodestabelecimento(codestabelecimentoavaliacao); 

	  Avaliacao avaliacao = ra.findByCodavaliacao(codavaliacao);
	
	  
	  Estabelecimentoavaliacao estabelecimentoavaliacao = rea.getOne(codestabelecimentoavaliacao);
		
	  estabelecimentoavaliacao.setAvaliacao(avaliacao);
	  estabelecimentoavaliacao.setEstabelecimento(estabelecimento);
	  estabelecimentoavaliacao.setCometario(comentario);
	  estabelecimentoavaliacao.setPontuacao(pontuacao);
	 
				
	  return estabelecimentoavaliacao;
	 
}   
	
}
