package com.etec.informacoes_turisricas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etec.informacoes_turisricas.model.Telefone;





public interface R_Telefone extends JpaRepository<Telefone, Long>{
	Telefone findByNumero(String numero);
}
