package br.com.djricardo.portifolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.djricardo.portifolio.model.Eventos;

public interface EventosRepository extends JpaRepository<Eventos, Long> {
	
	public List<Eventos> findAllByTituloContainingIgnoreCase(String titulo);

}
