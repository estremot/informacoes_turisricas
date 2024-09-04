package com.etec.informacoes_turisricas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etec.informacoes_turisricas.model.Cidade;



public interface R_Cidade extends JpaRepository<Cidade, Long> {
	Cidade findByNomecidade(String nomecidade);
}
