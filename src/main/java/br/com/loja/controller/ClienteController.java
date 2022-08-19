package br.com.loja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.loja.model.Cerveja;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/cliente")
@Controller
public class ClienteController {

	@RequestMapping("/novo")
	public String cliente(Cerveja cerveja) {
		log.info("Acessando tela de Cliente");
		return "cerveja/cadastro-cliente";
	}
	
}
