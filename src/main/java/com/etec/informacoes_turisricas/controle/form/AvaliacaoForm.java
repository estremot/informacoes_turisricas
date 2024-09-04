package com.etec.informacoes_turisricas.controle.form;

import java.sql.Date;

import com.etec.informacoes_turisricas.model.Avaliacao;
import com.etec.informacoes_turisricas.model.Bairro;
import com.etec.informacoes_turisricas.model.Cep;
import com.etec.informacoes_turisricas.model.Cidade;
import com.etec.informacoes_turisricas.model.Estabelecimento;
import com.etec.informacoes_turisricas.model.Numero;
import com.etec.informacoes_turisricas.model.Rua;
import com.etec.informacoes_turisricas.model.Uf;
import com.etec.informacoes_turisricas.model.Usuario;
import com.etec.informacoes_turisricas.repository.R_Avaliacao;
import com.etec.informacoes_turisricas.repository.R_Bairro;
import com.etec.informacoes_turisricas.repository.R_Cep;
import com.etec.informacoes_turisricas.repository.R_Cidade;
import com.etec.informacoes_turisricas.repository.R_Estabelecimento;
import com.etec.informacoes_turisricas.repository.R_Numero;
import com.etec.informacoes_turisricas.repository.R_Rua;
import com.etec.informacoes_turisricas.repository.R_Uf;
import com.etec.informacoes_turisricas.repository.R_Usuario;

public class AvaliacaoForm {
	private Long codavaliacao;
	private Date dataavaliacao;

	private String nomeusuario;

	public Long getCodavaliacao() {
		return codavaliacao;
	}

	public void setCodavaliacao(Long codavaliacao) {
		this.codavaliacao = codavaliacao;
	}

	public Date getDataavaliacao() {
		return dataavaliacao;
	}

	public void setDataavaliacao(Date dataavaliacao) {
		this.dataavaliacao = dataavaliacao;
	}

	public String getNomeusuario() {
		return nomeusuario;
	}

	public void setNomeusuario(String nomeusuario) {
		this.nomeusuario = nomeusuario;
	}

	public Avaliacao converter(R_Usuario ru) {

		Usuario usuario = ru.findByNomeusuario(nomeusuario);

		return new Avaliacao(dataavaliacao, usuario);

	}

	public Avaliacao atualizar(Long codavaliacao, Date dataavaliacao, R_Usuario ru, R_Avaliacao ra) {
		// TODO Auto-generated method stub

		Usuario usuario = ru.findByNomeusuario(nomeusuario);

		Avaliacao avaliacao = ra.getOne(codavaliacao);

		avaliacao.setUsuario(usuario);
		avaliacao.setDataavaliacao(dataavaliacao);

		return avaliacao;

	}

}
