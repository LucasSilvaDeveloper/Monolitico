package br.com.loja.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.loja.storage.interfaces.IFotoStorage;
import br.com.loja.storage.local.FotoStorageLocal;

@Configuration
public class FotoStorageConfig {

    @Bean
    IFotoStorage fotoStorageLocal() {
        return new FotoStorageLocal();
    }
	
}
