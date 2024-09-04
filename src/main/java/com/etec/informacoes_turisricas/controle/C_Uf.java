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
import com.etec.informacoes_turisricas.repository.R_Uf;

import jakarta.transaction.Transactional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/turistico/ufs")
public class C_Uf {
	@Autowired
	private R_Uf repositoryUf;

	@GetMapping
	public List<Uf> lista() //DTO - Data Transfer Object
	{
			List<Uf> ufs = repositoryUf.findAll();
			return ufs;
	}
	
		
			
	@GetMapping("/{id}")
	public Uf retornaUfId(@PathVariable Long id) {
		Uf uf = repositoryUf.getOne(id);
		return uf;
	}
	
	@DeleteMapping("/{id}")
	public String deletaId(@PathVariable Long id) {
		
		repositoryUf.deleteById(id);
		return "Campo deletado com id = "+id;
	}
	
	@PostMapping()
	public String salvarDados(@RequestBody Uf uf) {
		
		repositoryUf.save(uf);
		return "Dados do Usuário salvos com sucesso!!";
	}
	
	@PutMapping("/{id}")
	@Transactional
	public String atualizaDados(@PathVariable Long id, @RequestBody Uf uf) {
		
		 uf.setCoduf(id);
		 repositoryUf.save(uf);

		return "Dados Atualizados";
	}

}
