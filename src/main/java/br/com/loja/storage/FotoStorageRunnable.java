package br.com.loja.storage;

import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import br.com.loja.model.dto.FotoDTO;
import br.com.loja.storage.interfaces.IFotoStorage;

public class FotoStorageRunnable implements Runnable {

	private MultipartFile[] file;
	private DeferredResult<FotoDTO> resutlado;
	private IFotoStorage iFotoStorage;
	
	public FotoStorageRunnable(MultipartFile[] file, DeferredResult<FotoDTO> resutlado, IFotoStorage iFotoStorage) {
		this.file = file;
		this.resutlado = resutlado;
		this.iFotoStorage = iFotoStorage;
	}

	@Override
	public void run() {
		System.out.println(file[0].getSize());
		
		this.iFotoStorage.salvarTemporariamente(file);
		
		resutlado.setResult(new FotoDTO(file[0].getOriginalFilename(), file[0].getContentType()));
	}

	
}
