package br.com.loja.config;

import java.math.BigDecimal;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.number.NumberStyleFormatter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatterForFieldType(BigDecimal.class, new NumberStyleFormatter("#,##0.00"));
		registry.addFormatterForFieldType(Integer.class, new NumberStyleFormatter("#,##0"));
	}
	
}
