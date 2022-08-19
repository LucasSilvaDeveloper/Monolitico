package br.com.loja.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.loja.model.Estilo;
import br.com.loja.service.EstiloService;
import br.com.loja.service.exception.NomeEstiloCadastradoException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/estilo")
@Controller
public class EstiloController {
	
	@Autowired
	private EstiloService estiloService;

	@RequestMapping("/novo")
	public ModelAndView novo(Estilo estilo) {
		log.info("Acessando tela de Estilo");
		return new ModelAndView("cerveja/cadastro-estilo");
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Estilo estilo, BindingResult result, RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			return novo(estilo);
		}
		
		try {
			estiloService.save(estilo);
		} catch (NomeEstiloCadastradoException e) {
			log.error(e.getMessage());
			result.rejectValue("nome", e.getMessage(), e.getMessage());
			return novo(estilo);
		}
		
		attributes.addFlashAttribute("mensagem", "Estilo Salvo com sucesso!");
		return new ModelAndView("redirect:/estilo/novo");
	}

	@RequestMapping(value = "/cadastro-rapido", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> salvar(@Valid @RequestBody Estilo estilo, BindingResult result ) {
		
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().body(result.getFieldError("nome").getDefaultMessage());
		}

		return ResponseEntity.ok(estiloService.save(estilo));
	}
}