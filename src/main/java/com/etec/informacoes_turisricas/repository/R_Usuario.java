package com.etec.informacoes_turisricas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etec.informacoes_turisricas.model.Usuario;


public interface R_Usuario extends JpaRepository<Usuario, Long>{
	Usuario findByNomeusuario(String nomeusuario);
}
