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

import com.etec.informacoes_turisricas.model.Cidade;
import com.etec.informacoes_turisricas.repository.R_Cidade;

import jakarta.transaction.Transactional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/turistico/cidades")
public class C_Cidade {


	@Autowired
	private R_Cidade repositoryCidade;

	@GetMapping
	public List<Cidade> lista() //DTO - Data Transfer Object
	{
			List<Cidade> cidades = repositoryCidade.findAll();
			return cidades;
	}
	
		
			
	@GetMapping("/{id}")
	public Cidade retornaCidadeId(@PathVariable Long id) {
		Cidade cidade = repositoryCidade.getOne(id);
		return cidade;
	}
	
	@DeleteMapping("/{id}")
	public String deletaId(@PathVariable Long id) {
		
		repositoryCidade.deleteById(id);
		return "Campo deletado com id = "+id;
	}
	
	@PostMapping()
	public String salvarDados(@RequestBody Cidade cidade) {
		
		repositoryCidade.save(cidade);
		return "Dados do Usuário salvos com sucesso!!";
	}
	
	@PutMapping("/{id}")
	@Transactional
	public String atualizaDados(@PathVariable Long id, @RequestBody Cidade cidade) {
		
		 cidade.setCodcidade(id);
		 repositoryCidade.save(cidade);

		return "Dados Atualizados";
	}
	
}
