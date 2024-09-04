package com.etec.informacoes_turisricas.controle.form;

import java.sql.Date;

import com.etec.informacoes_turisricas.model.Bairro;
import com.etec.informacoes_turisricas.model.Cep;
import com.etec.informacoes_turisricas.model.Cidade;
import com.etec.informacoes_turisricas.model.Estabelecimento;
import com.etec.informacoes_turisricas.model.Numero;
import com.etec.informacoes_turisricas.model.Rua;
import com.etec.informacoes_turisricas.model.Uf;
import com.etec.informacoes_turisricas.repository.R_Bairro;
import com.etec.informacoes_turisricas.repository.R_Cep;
import com.etec.informacoes_turisricas.repository.R_Cidade;
import com.etec.informacoes_turisricas.repository.R_Estabelecimento;
import com.etec.informacoes_turisricas.repository.R_Numero;
import com.etec.informacoes_turisricas.repository.R_Rua;
import com.etec.informacoes_turisricas.repository.R_Uf;



public class EstabelecimentoForm {
	private Long codestabelecimento;
	private String nomefantasia;
	private String razaosocial;
	private Date datacriacao;
    private String nomerua;
   private  String numeroend;
   private  String nomebairro;
   private String numerocep;
   private String nomecidade;
   private String nomeuf;
   
     
   
   
public Long getCodestabelecimento() {
	return codestabelecimento;
}

public void setCodestabelecimento(Long codestabelecimento) {
	this.codestabelecimento = codestabelecimento;
}




public String getNomefantasia() {
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

public String getNomerua() {
	return nomerua;
}

public void setNomerua(String nomerua) {
	this.nomerua = nomerua;
}

public String getNumeroend() {
	return numeroend;
}

public void setNumeroend(String numeroend) {
	this.numeroend = numeroend;
}

public String getNomebairro() {
	return nomebairro;
}

public void setNomebairro(String nomebairro) {
	this.nomebairro = nomebairro;
}

public String getNumerocep() {
	return numerocep;
}

public void setNumerocep(String numerocep) {
	this.numerocep = numerocep;
}

public String getNomecidade() {
	return nomecidade;
}

public void setNomecidade(String nomecidade) {
	this.nomecidade = nomecidade;
}

public String getNomeuf() {
	return nomeuf;
}

public void setNomeuf(String nomeuf) {
	this.nomeuf = nomeuf;
}

public Estabelecimento converter(R_Rua rr, R_Numero rn, R_Bairro rb, R_Cep rc, R_Cidade rcid, R_Uf ru) {
	
	Rua rua = rr.findByNomerua(nomerua);
	Numero numero = rn.findByNumeroend(numeroend);
	Bairro bairro = rb.findByNomebairro(nomebairro);
	Cep cep = rc.findByNumerocep(numerocep);
    Cidade cidade = rcid.findByNomecidade(nomecidade);
    Uf uf =  ru.findByNomeuf(nomeuf);
    
   

	return new Estabelecimento(nomefantasia, razaosocial, datacriacao, rua, numero, bairro, cep, cidade,  uf);

}

public Estabelecimento atualizar(Long codestabelecimento, R_Rua rr, R_Numero rn, R_Bairro rb, R_Cep rc, R_Cidade rcid, R_Uf ru, R_Estabelecimento re ) {
	// TODO Auto-generated method stub

	
	  Rua rua = rr.findByNomerua(nomerua); 

	  Numero numero = rn.findByNumeroend(numeroend);
	
	  Bairro bairro = rb.findByNomebairro(nomebairro);
	  
	  Cep cep = rc.findByNumerocep(numerocep);
	  
	  Cidade cidade = rcid.findByNomecidade(nomecidade);
	  
	  Uf uf = ru.findByNomeuf(nomeuf);
	  
	  Estabelecimento estabelecimento = re.getOne(codestabelecimento);
		
	  estabelecimento.setBairro(bairro);
	  estabelecimento.setRua(rua);
	  estabelecimento.setNumero(numero);
	  estabelecimento.setCep(cep);
	  estabelecimento.setCidade(cidade);
	  estabelecimento.setUf(uf);
	  estabelecimento.setNomefantasia(nomefantasia);
	  estabelecimento.setRazaosocial(razaosocial);
	  estabelecimento.setDatacriacao(datacriacao);
				
	  return estabelecimento;
	 
}   
	
}
