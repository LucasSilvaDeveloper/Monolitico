package br.com.loja.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.loja.model.Estilo;

@Repository
public interface EstiloRepository extends JpaRepository<Estilo, Long>{

	Optional<Estilo> findByNomeIgnoreCase(String nome);
	
}
