package br.com.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.cursomc.services.DBService;
import br.com.cursomc.services.EmailService;
import br.com.cursomc.services.MockEmailService;

//CONFIGURAÇÕES ESPECIFICAS PARA O PROFILE DE TESTE
@Configuration
//ESPECIFICA O PROFILE QUE SERÁ UTILIZADO
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService dbService;
	
	//PRECISA RETORNAR ALGO
	//AO INVÉS DE ENXER O ARQUIVO PRINCIPAL, É INSERIDO APENAS NO TESTE (NA CONFIGURAÇÃO)
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbService.instantiateTestDataBase();
		return true;
	}
	
	//QUANDO UTILIZA A ANOTAÇÃO BEAN ESSE CARA VAI ESTAR DISPONIVEL COMO COMPONENTE NO NOSSO SISTEMA
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}
}
