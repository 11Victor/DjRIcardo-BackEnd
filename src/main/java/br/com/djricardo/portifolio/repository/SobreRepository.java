package br.com.djricardo.portifolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.djricardo.portifolio.model.Sobre;

public interface SobreRepository extends JpaRepository<Sobre, Long> {
	
	public List<Sobre> findAllByTextoContainingIgnoreCase(String texto);
	
}
