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

import com.etec.informacoes_turisricas.controle.form.AvaliacaoForm;
import com.etec.informacoes_turisricas.model.Avaliacao;
import com.etec.informacoes_turisricas.repository.R_Avaliacao;
import com.etec.informacoes_turisricas.repository.R_Usuario;

import jakarta.transaction.Transactional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/turistico/avaliacoes")
public class C_Avaliacao {
	@Autowired
	private R_Avaliacao ra;
	
	@Autowired
	private R_Usuario ru;
	
	@GetMapping
	public List<Avaliacao> lista() //DTO - Data Transfer Object
	{
			List<Avaliacao> avaliacoes = ra.findAll();
			return avaliacoes;
	}
	
			
	@GetMapping("/{id}")
	public Avaliacao retornaPlantaId(@PathVariable Long id) {
		Avaliacao planta = ra.getOne(id);
		return planta;
	}
	
	@DeleteMapping("/{id}")
	public String deletaId(@PathVariable Long id) {
		
		ra.deleteById(id);
		return "Campo deletado com id = "+id;
	}
	
	@PostMapping()
	public String salvarDados(@RequestBody AvaliacaoForm form) {
		
		Avaliacao avaliacao = form.converter(ru);
	    ra.save(avaliacao);
		return "Dados do Usuário salvos com sucesso!!";
	}
	
	@PutMapping("/{id}")
	@Transactional
	public String atualizaDados(@PathVariable Long id, @RequestBody Avaliacao avaliacao) {
		
		 avaliacao.setCodavaliacao(id);
		 ra.save(avaliacao);

		return "Dados Atualizados";
	}

}
