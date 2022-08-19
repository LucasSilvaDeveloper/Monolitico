package br.com.loja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.loja.model.Cerveja;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/usuario")
@Controller
public class UsuarioController {

	@RequestMapping("/novo")
	public String usuario(Cerveja cerveja) {
		log.info("Acessando tela de Usuario");
		return "cerveja/cadastro-usuario";  
	}
	
}
