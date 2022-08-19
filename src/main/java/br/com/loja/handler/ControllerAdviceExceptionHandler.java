package br.com.loja.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.loja.service.exception.NomeEstiloCadastradoException;

@ControllerAdvice
public class ControllerAdviceExceptionHandler {

	@ExceptionHandler(NomeEstiloCadastradoException.class)
	public ResponseEntity<String> handlerNomeEstiloCadastradoException(NomeEstiloCadastradoException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}
	
}
