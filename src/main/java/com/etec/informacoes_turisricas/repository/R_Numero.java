package com.etec.informacoes_turisricas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etec.informacoes_turisricas.model.Numero;



public interface R_Numero extends JpaRepository<Numero, Long>{
	Numero findByNumeroend(String numeroend);
}
