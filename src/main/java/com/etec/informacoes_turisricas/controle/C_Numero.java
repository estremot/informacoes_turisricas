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

import com.etec.informacoes_turisricas.model.Numero;
import com.etec.informacoes_turisricas.repository.R_Numero;

import jakarta.transaction.Transactional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/turistico/numeros")
public class C_Numero {
	@Autowired
	private R_Numero repositoryNumero;

	@GetMapping
	public List<Numero> lista() //DTO - Data Transfer Object
	{
			List<Numero> numeros = repositoryNumero.findAll();
			return numeros;
	}
	
		
			
	@GetMapping("/{id}")
	public Numero retornaNumeroId(@PathVariable Long id) {
		Numero datacomemorativa = repositoryNumero.getOne(id);
		return datacomemorativa;
	}
	
	@DeleteMapping("/{id}")
	public String deletaId(@PathVariable Long id) {
		
		repositoryNumero.deleteById(id);
		return "Campo deletado com id = "+id;
	}
	
	@PostMapping()
	public String salvarDados(@RequestBody Numero datacomemorativa) {
		
		repositoryNumero.save(datacomemorativa);
		return "Dados do Usuário salvos com sucesso!!";
	}
	
	@PutMapping("/{id}")
	@Transactional
	public String atualizaDados(@PathVariable Long id, @RequestBody Numero numero) {
		
		 numero.setCodnumero(id);
		 repositoryNumero.save(numero);

		return "Dados Atualizados";
	}

}