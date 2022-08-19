package br.com.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.model.Estilo;
import br.com.loja.repository.EstiloRepository;
import br.com.loja.service.exception.NomeEstiloCadastradoException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EstiloService {

	@Autowired
	private EstiloRepository estiloRepository;
	
	public Estilo save(Estilo estilo) {
		log.info("Salvando Estilo");
		
		if (estiloRepository.findByNomeIgnoreCase(estilo.getNome()).isPresent()) {
			throw new NomeEstiloCadastradoException("Nome do estilo ja cadastrado!");
		}else {
			Estilo estiloSalvo = estiloRepository.saveAndFlush(estilo);
			log.info("Estilo salvo com sucesso!");
			return estiloSalvo;
		}
		
	}
	
}
