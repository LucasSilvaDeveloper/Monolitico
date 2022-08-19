package br.com.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.loja.model.Cerveja;

@Repository
public interface CervejaRepository extends JpaRepository<Cerveja, Long>{
	
}
