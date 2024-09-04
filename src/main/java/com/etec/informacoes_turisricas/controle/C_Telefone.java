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
import com.etec.informacoes_turisricas.controle.form.TelefoneForm;
import com.etec.informacoes_turisricas.model.Avaliacao;
import com.etec.informacoes_turisricas.model.Telefone;
import com.etec.informacoes_turisricas.repository.R_Avaliacao;
import com.etec.informacoes_turisricas.repository.R_Estabelecimento;
import com.etec.informacoes_turisricas.repository.R_Telefone;
import com.etec.informacoes_turisricas.repository.R_Usuario;

import jakarta.transaction.Transactional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/turistico/telefones")
public class C_Telefone {
	@Autowired
	private R_Telefone rt;
	
	@Autowired
	private R_Estabelecimento re;
	
	@GetMapping
	public List<Telefone> lista() //DTO - Data Transfer Object
	{
			List<Telefone> telefones = rt.findAll();
			return telefones;
	}
	
			
	@GetMapping("/{id}")
	public Telefone retornaTelefoneId(@PathVariable Long id) {
		Telefone telefone = rt.getOne(id);
		return telefone;
	}
	
	@DeleteMapping("/{id}")
	public String deletaId(@PathVariable Long id) {
		
		rt.deleteById(id);
		return "Campo deletado com id = "+id;
	}
	
	@PostMapping()
	public String salvarDados(@RequestBody TelefoneForm form) {
		
		Telefone telefone = form.converter(re);
	    rt.save(telefone);
		return "Dados do Usuário salvos com sucesso!!";
	}
	
	@PutMapping("/{id}")
	@Transactional
	public String atualizaDados(@PathVariable Long id, @RequestBody Telefone telefone) {
		
		 telefone.setCodtelefone(id);
		 rt.save(telefone);

		return "Dados Atualizados";
	}

}
