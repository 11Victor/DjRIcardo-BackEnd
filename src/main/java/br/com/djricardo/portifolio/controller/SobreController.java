package br.com.djricardo.portifolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.djricardo.portifolio.model.Sobre;
import br.com.djricardo.portifolio.repository.SobreRepository;

@RestController
@RequestMapping("/sobre")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SobreController {
	
	
	@Autowired
	private SobreRepository sobreRepository;
	
	// Consultar todos Sobre
	@GetMapping
	public ResponseEntity <List<Sobre>> getAll(){
		return ResponseEntity.ok(sobreRepository.findAll());
	}
	
	
	// Consultar Sobre por ID
	@GetMapping("/{id}")
	public ResponseEntity<Sobre> getById(@PathVariable long id){
		return sobreRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	// Consultar Sobre por Titulo
	@GetMapping("/texto/{texto}")
	public ResponseEntity<List<Sobre>> getByTexto(@PathVariable String texto){
		return ResponseEntity.ok(sobreRepository.findAllByTextoContainingIgnoreCase(texto));
	}
	
	// Cadastrar Sobre
	@PostMapping
	public ResponseEntity<Sobre> postSobre(@RequestBody Sobre Sobre){
		return ResponseEntity.status(HttpStatus.CREATED).body(sobreRepository.save(Sobre));
	}
	
	// Editar Sobre
	@PutMapping
	public ResponseEntity<Sobre> putSobre(@RequestBody Sobre Sobre){
		return ResponseEntity.status(HttpStatus.OK).body(sobreRepository.save(Sobre));
	}
	
	// Deletar Sobre
	@DeleteMapping("/{id}")
	public void deleteSobre(@PathVariable long id){
		sobreRepository.deleteById(id);
	}
	
	
}
