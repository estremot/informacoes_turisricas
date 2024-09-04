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

import com.etec.informacoes_turisricas.model.Bairro;
import com.etec.informacoes_turisricas.repository.R_Bairro;

import jakarta.transaction.Transactional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/turistico/bairros")
public class C_Bairro {
	@Autowired
	private R_Bairro repositoryBairro;

	@GetMapping
	public List<Bairro> lista() //DTO - Data Transfer Object
	{
			List<Bairro> bairros = repositoryBairro.findAll();
			return bairros;
	}
	
		
			
	@GetMapping("/{id}")
	public Bairro retornaBairroId(@PathVariable Long id) {
		Bairro bairro = repositoryBairro.getOne(id);
		return bairro;
	}
	
	@DeleteMapping("/{id}")
	public String deletaId(@PathVariable Long id) {
		
		repositoryBairro.deleteById(id);
		return "Campo deletado com id = "+id;
	}
	
	@PostMapping()
	public String salvarDados(@RequestBody Bairro bairro) {
		
		repositoryBairro.save(bairro);
		return "Dados do Usuário salvos com sucesso!!";
	}
	
	@PutMapping("/{id}")
	@Transactional
	public String atualizaDados(@PathVariable Long id, @RequestBody Bairro bairro) {
		
		 bairro.setCodbairro(id);
		 repositoryBairro.save(bairro);

		return "Dados Atualizados";
	}

}
