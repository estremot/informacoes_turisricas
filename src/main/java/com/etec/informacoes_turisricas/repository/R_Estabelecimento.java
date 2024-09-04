package com.etec.informacoes_turisricas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etec.informacoes_turisricas.model.Estabelecimento;




public interface R_Estabelecimento extends JpaRepository<Estabelecimento, Long>{
	
	Estabelecimento findByRazaosocial(String razaosocial);
	
	Estabelecimento findByCodestabelecimento(Long codestabelecimento);

}
