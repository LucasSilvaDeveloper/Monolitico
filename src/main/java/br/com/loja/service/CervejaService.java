package br.com.loja.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.model.Cerveja;
import br.com.loja.repository.CervejaRepository;

@Service
public class CervejaService {

	@Autowired
	private CervejaRepository cervejaRepository;
	
	public List<Cerveja> findAll(){
		return cervejaRepository.findAll();
	}

	public void save(@Valid Cerveja cerveja) {
		cervejaRepository.save(cerveja);
	}
	
}
