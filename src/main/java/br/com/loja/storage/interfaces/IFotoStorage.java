package br.com.loja.storage.interfaces;

import org.springframework.web.multipart.MultipartFile;

public interface IFotoStorage {

	public void salvarTemporariamente(MultipartFile[] file);
	
}
