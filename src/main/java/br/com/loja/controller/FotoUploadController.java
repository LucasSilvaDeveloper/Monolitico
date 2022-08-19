package br.com.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import br.com.loja.model.dto.FotoDTO;
import br.com.loja.storage.FotoStorageRunnable;
import br.com.loja.storage.interfaces.IFotoStorage;

@RestController
@RequestMapping("/foto")
public class FotoUploadController {
	
	@Autowired
	private IFotoStorage iFotoStorage;

	@RequestMapping("/upload")
	@PostMapping
	public DeferredResult<FotoDTO> upload(@RequestParam("files[]") MultipartFile[] file) {
		
		DeferredResult<FotoDTO> resultado = new DeferredResult<>();
		
		Thread thread = new Thread(new FotoStorageRunnable(file, resultado, iFotoStorage));
		thread.start();
		return resultado;
	}
	
}
