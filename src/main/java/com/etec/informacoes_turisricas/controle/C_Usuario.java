package com.etec.informacoes_turisricas.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etec.informacoes_turisricas.model.Uf;
import com.etec.informacoes_turisricas.model.Usuario;
import com.etec.informacoes_turisricas.repository.R_Uf;
import com.etec.informacoes_turisricas.repository.R_Usuario;

import jakarta.transaction.Transactional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/turistico/usuarios")
public class C_Usuario {
	@Autowired
	private R_Usuario repositoryUsuario;

	@GetMapping
	public List<Usuario> lista() //DTO - Data Transfer Object
	{
			List<Usuario> usuario = repositoryUsuario.findAll();
			return usuario;
	}
	
		
			
	@GetMapping("/{id}")
	public Usuario retornaUsuarioId(@PathVariable Long id) {
		Usuario usuario = repositoryUsuario.getOne(id);
		return usuario;
	}
	
	@DeleteMapping("/{id}")
	public String deletaId(@PathVariable Long id) {
		
		repositoryUsuario.deleteById(id);
		return "Campo deletado com id = "+id;
	}
	
	@PostMapping()
	public String salvarDados(@RequestBody Usuario usuario) {
		
		repositoryUsuario.save(usuario);
		return "Dados do Usuário salvos com sucesso!!";
	}
	
	@PutMapping("/{id}")
	@Transactional
	public String atualizaDados(@PathVariable Long id, @RequestBody Usuario usuario) {
		
		 usuario.setCodusuario(id);
		 repositoryUsuario.save(usuario);

		return "Dados Atualizados";
	}

}
