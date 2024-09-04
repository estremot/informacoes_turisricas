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

import com.etec.informacoes_turisricas.controle.form.EstabelecimentoForm;
import com.etec.informacoes_turisricas.model.Estabelecimento;
import com.etec.informacoes_turisricas.model.Estabelecimento;
import com.etec.informacoes_turisricas.repository.R_Estabelecimento;
import com.etec.informacoes_turisricas.repository.R_Bairro;
import com.etec.informacoes_turisricas.repository.R_Cep;
import com.etec.informacoes_turisricas.repository.R_Cidade;
import com.etec.informacoes_turisricas.repository.R_Estabelecimento;
import com.etec.informacoes_turisricas.repository.R_Numero;
import com.etec.informacoes_turisricas.repository.R_Rua;
import com.etec.informacoes_turisricas.repository.R_Uf;
import com.etec.informacoes_turisricas.repository.R_Usuario;

import jakarta.transaction.Transactional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/turistico/estabelecimentos")
public class C_Estabelecimento {
	@Autowired
	private R_Estabelecimento re;
	
	@Autowired
	private R_Rua rr;
	
	@Autowired
	private R_Numero rn;
	
	@Autowired
	private R_Bairro rb;
	
	@Autowired
	private R_Cep rc;
	
	@Autowired
	private R_Cidade rcid;
	
	@Autowired
	private R_Uf ruf;
	
		
	@GetMapping
	public List<Estabelecimento> lista() //DTO - Data Transfer Object
	{
			List<Estabelecimento> estabelecimentos = re.findAll();
			return estabelecimentos;
	}
	
			
	@GetMapping("/{id}")
	public Estabelecimento retornaPlantaId(@PathVariable Long id) {
		Estabelecimento estabekecimento = re.getOne(id);
		return estabekecimento;
	}
	
	@DeleteMapping("/{id}")
	public String deletaId(@PathVariable Long id) {
		
		re.deleteById(id);
		return "Campo deletado com id = "+id;
	}
	
	@PostMapping()
	public String salvarDados(@RequestBody EstabelecimentoForm form) {
		
		Estabelecimento estabelecimento = form.converter(rr, rn, rb, rc, rcid, ruf );
	    re.save(estabelecimento);
		return "Dados do Usuário salvos com sucesso!!";
	}
	
	@PutMapping("/{id}")
	@Transactional
	public String atualizaDados(@PathVariable Long id, @RequestBody Estabelecimento estabelecimento) {
		
		 estabelecimento.setCodestabelecimento(id);
		 re.save(estabelecimento);

		return "Dados Atualizados";
	}

}
