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

import br.com.djricardo.portifolio.model.Eventos;
import br.com.djricardo.portifolio.repository.EventosRepository;

@RestController
@RequestMapping("/eventos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EventosController {
	
	
	@Autowired
	private EventosRepository eventosRepository;
	
	// Consultar todos eventos
	@GetMapping
	public ResponseEntity <List<Eventos>> getAll(){
		return ResponseEntity.ok(eventosRepository.findAll());
	}
	
	
	// Consultar Eventos por ID
	@GetMapping("/{id}")
	public ResponseEntity<Eventos> getById(@PathVariable long id){
		return eventosRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	// Consultar Eventos por Titulo
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Eventos>> getByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(eventosRepository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	// Cadastrar Eventos
	@PostMapping
	public ResponseEntity<Eventos> postEventos(@RequestBody Eventos Eventos){
		return ResponseEntity.status(HttpStatus.CREATED).body(eventosRepository.save(Eventos));
	}
	
	// Editar Eventos
	@PutMapping
	public ResponseEntity<Eventos> putEventos(@RequestBody Eventos Eventos){
		return ResponseEntity.status(HttpStatus.OK).body(eventosRepository.save(Eventos));
	}
	
	// Deletar Eventos
	@DeleteMapping("/{id}")
	public void deleteEventos(@PathVariable long id){
		eventosRepository.deleteById(id);
	}
	
	
}
