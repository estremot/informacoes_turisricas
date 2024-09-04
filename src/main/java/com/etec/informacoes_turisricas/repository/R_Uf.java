package com.etec.informacoes_turisricas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etec.informacoes_turisricas.model.Uf;




public interface R_Uf extends JpaRepository<Uf, Long>{
	Uf findByNomeuf(String nomeuf);
}
