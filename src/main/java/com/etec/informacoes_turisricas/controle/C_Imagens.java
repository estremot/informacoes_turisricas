package com.etec.informacoes_turisricas.controle;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.etec.informacoes_turisricas.controle.form.ImagensForm;
import com.etec.informacoes_turisricas.model.Imagens;
import com.etec.informacoes_turisricas.repository.R_Estabelecimento;
import com.etec.informacoes_turisricas.repository.R_Imagens;

import jakarta.transaction.Transactional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/turistico/imagens")
public class C_Imagens {

	@Autowired
	private R_Imagens repositoryImagens;
	
	@Autowired
	private R_Estabelecimento repositoryEstabelecimento;

	@GetMapping
	public List<Imagens> lista() //DTO - Data Transfer Object
	{
			List<Imagens> imagens = repositoryImagens.findAll();
			return imagens;
	}
	
		
			
	@GetMapping("/{id}")
	public Imagens retornaImagensId(@PathVariable Long id) {
		Imagens imagem = repositoryImagens.getOne(id);
		return imagem;
	}
	
	@DeleteMapping("/{id}")
	public String deletaId(@PathVariable Long id) {
		
		repositoryImagens.deleteById(id);
		return "Campo deletado com id = "+id;
	}
	
	@PostMapping //enctype: Multipart/form-data
	public String salvarDados(@RequestPart("imagem") ImagensForm form,@RequestPart("file") MultipartFile file)  {
		
		Imagens imagem = form.converter(repositoryEstabelecimento);
		
		try {
			imagem.setFoto(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		repositoryImagens.save(imagem);
		return "Dados do Usuário salvos com sucesso!!";
	}
	
	@PutMapping("/{id}")
	@Transactional
	public String atualizaDados(@PathVariable Long id, @RequestBody Imagens imagem) {
		
		 imagem.setCodimagem(id);
		 repositoryImagens.save(imagem);

		return "Dados Atualizados";
	}
}
