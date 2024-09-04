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

import com.etec.informacoes_turisricas.model.Rua;
import com.etec.informacoes_turisricas.repository.R_Rua;

import jakarta.transaction.Transactional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/turistico/ruas")
public class C_Rua {
	@Autowired
	private R_Rua repositoryRua;

	@GetMapping
	public List<Rua> lista() //DTO - Data Transfer Object
	{
			List<Rua> ruas = repositoryRua.findAll();
			return ruas;
	}
	
		
			
	@GetMapping("/{id}")
	public Rua retornaRuaId(@PathVariable Long id) {
		Rua rua = repositoryRua.getOne(id);
		return rua;
	}
	
	@DeleteMapping("/{id}")
	public String deletaId(@PathVariable Long id) {
		
		repositoryRua.deleteById(id);
		return "Campo deletado com id = "+id;
	}
	
	@PostMapping()
	public String salvarDados(@RequestBody Rua rua) {
		
		repositoryRua.save(rua);
		return "Dados do Usuário salvos com sucesso!!";
	}
	
	@PutMapping("/{id}")
	@Transactional
	public String atualizaDados(@PathVariable Long id, @RequestBody Rua rua) {
		
		 rua.setCodrua(id);
		 repositoryRua.save(rua);

		return "Dados Atualizados";
	}

}
