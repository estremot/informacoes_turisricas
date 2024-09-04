package com.etec.informacoes_turisricas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etec.informacoes_turisricas.model.Avaliacao;
import com.etec.informacoes_turisricas.model.Bairro;



public interface R_Avaliacao extends JpaRepository<Avaliacao, Long>{
	
	Avaliacao findByCodavaliacao(Long codavaliacao);

}
