package com.etec.informacoes_turisricas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etec.informacoes_turisricas.model.Bairro;



public interface R_Bairro extends JpaRepository<Bairro, Long>{
	
	Bairro findByNomebairro(String nomebairro);

}
