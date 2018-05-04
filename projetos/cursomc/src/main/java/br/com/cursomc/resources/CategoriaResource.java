package br.com.cursomc.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//CONTROLADOR REST E RESPONDERÁ PELO END POINT /CATEGORIAS
@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	//CAIRÁ AQUI QUANDO UTILIZAR O /categorias NO GET
	@RequestMapping(method=RequestMethod.GET)
	public String listar() {
		return "REST está funcionando!";
	}
	
}
