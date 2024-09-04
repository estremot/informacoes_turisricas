package com.etec.informacoes_turisricas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etec.informacoes_turisricas.model.Avaliacao;
import com.etec.informacoes_turisricas.model.Bairro;
import com.etec.informacoes_turisricas.model.Estabelecimentoavaliacao;



public interface R_Estabelecimentoavaliacao extends JpaRepository<Estabelecimentoavaliacao, Long>{
	
	Estabelecimentoavaliacao findByCodestabelecimentoavaliacao(int codestabelecimentoavaliacao);

}
