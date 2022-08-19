package br.com.loja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.loja.model.Cerveja;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/cidade")
@Controller
public class CidadeController {

	@RequestMapping("/novo")
	public String cidade(Cerveja cerveja) {
		log.info("Acessando tela de Cidade");
		return "cerveja/cadastro-cidade";  
	}
	
}
