package br.com.loja.storage.local;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.web.multipart.MultipartFile;

import br.com.loja.storage.interfaces.IFotoStorage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FotoStorageLocal implements IFotoStorage{

	private Path local;
	private Path localTemporario;
	
	public FotoStorageLocal() {
		this.local = FileSystems.getDefault().getPath(System.getProperty("user.dir"), "fotos");
		criarPastas();
	}

	private void criarPastas() {
		try {
			Files.createDirectories(this.local);
			this.localTemporario = FileSystems.getDefault().getPath(this.local.toString(), "temp");
			Files.createDirectories(this.localTemporario);
			
			log.info("Pastas criadas para salvar fotos");
			log.info("Pasta Default " + this.local.toAbsolutePath());
			log.info("Pasta temporaria " + this.localTemporario.toAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
			log.warn("Erro ao criar pasta para salva imagem ou foto!");
			log.warn(e.getMessage());
		}
	}

	@Override
	public void salvarTemporariamente(MultipartFile[] file) {

		System.out.println("Salvando a foto temporariamente");
	}
	
}
