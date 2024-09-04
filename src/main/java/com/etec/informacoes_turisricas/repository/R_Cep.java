package com.etec.informacoes_turisricas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etec.informacoes_turisricas.model.Cep;



public interface R_Cep extends JpaRepository<Cep, Long>{
	Cep findByNumerocep(String numerocep);

}
