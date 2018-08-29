package br.com.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.cursomc.services.DBService;

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
}
