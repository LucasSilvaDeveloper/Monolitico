package br.com.loja.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.loja.model.Cerveja;
import br.com.loja.model.enums.Origem;
import br.com.loja.model.enums.Sabor;
import br.com.loja.repository.EstiloRepository;
import br.com.loja.service.CervejaService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/cerveja")
@Controller
public class CervejaController {
	
	@Autowired
	private CervejaService cervejaService;
	
	@Autowired
	private EstiloRepository estiloRepository;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Cerveja cerveja) {
		log.info("Acessando tela de Cerveja");
		
		ModelAndView mv = new ModelAndView("cerveja/cadastro-cerveja");
		mv.addObject("sabores", Sabor.values());
		mv.addObject("estilos", estiloRepository.findAll());
		mv.addObject("origens", Origem.values());
		return mv;  
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Cerveja cerveja, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			return novo(cerveja);
		}
		
		cervejaService.save(cerveja);
		attributes.addFlashAttribute("mensagem", "Cerveja Salva com sucesso!");
		return new ModelAndView("redirect:/cerveja/novo");  
	}
	
}
