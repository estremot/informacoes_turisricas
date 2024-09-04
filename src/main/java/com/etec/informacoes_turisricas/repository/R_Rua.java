package com.etec.informacoes_turisricas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etec.informacoes_turisricas.model.Rua;



public interface R_Rua extends JpaRepository<Rua, Long> {
	Rua findByNomerua(String nomerua);
}
