package com.etec.informacoes_turisricas.controle.form;

import java.sql.Date;

import com.etec.informacoes_turisricas.model.Bairro;
import com.etec.informacoes_turisricas.model.Cep;
import com.etec.informacoes_turisricas.model.Cidade;
import com.etec.informacoes_turisricas.model.Estabelecimento;
import com.etec.informacoes_turisricas.model.Numero;
import com.etec.informacoes_turisricas.model.Rua;
import com.etec.informacoes_turisricas.model.Telefone;
import com.etec.informacoes_turisricas.model.Uf;
import com.etec.informacoes_turisricas.repository.R_Bairro;
import com.etec.informacoes_turisricas.repository.R_Cep;
import com.etec.informacoes_turisricas.repository.R_Cidade;
import com.etec.informacoes_turisricas.repository.R_Estabelecimento;
import com.etec.informacoes_turisricas.repository.R_Numero;
import com.etec.informacoes_turisricas.repository.R_Rua;
import com.etec.informacoes_turisricas.repository.R_Telefone;
import com.etec.informacoes_turisricas.repository.R_Uf;



public class TelefoneForm {
	private Long codtelefone;
	private String numero;
    private Long codestabelecimento;
 


public Long getCodtelefone() {
		return codtelefone;
	}

	public void setCodtelefone(Long codtelefone) {
		this.codtelefone = codtelefone;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	
	public Long getCodestabelecimento() {
		return codestabelecimento;
	}

	public void setCodestabelecimento(Long codestabelecimento) {
		this.codestabelecimento = codestabelecimento;
	}

public Telefone converter(R_Estabelecimento re) {
	
	Estabelecimento estabelecimento = re.getById(codestabelecimento);
	
   
	return new Telefone(numero, estabelecimento);

}

public Telefone atualizar(Long codtelefone, R_Estabelecimento re, R_Telefone rt ) {
	// TODO Auto-generated method stub

	
	  Estabelecimento estabelecimento = re.getById(codestabelecimento); 

	    
	  Telefone telefone = rt.getOne(codtelefone);
		
	  telefone.setEstabelecimento(estabelecimento);
	  telefone.setNumero(numero);
	 
				
	  return telefone;
	 
}   
	
}
