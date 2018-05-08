package br.com.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cursomc.domain.Categoria;

//CONTROLADOR REST E RESPONDERÁ PELO END POINT /CATEGORIAS
@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	//CAIRÁ AQUI QUANDO UTILIZAR O /categorias NO GET
	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> listar() {
		
		Categoria cat1 = new Categoria(1, "Informática");
		Categoria cat2 = new Categoria(2, "Escritório");
		
		List<Categoria> lista = new ArrayList<>();
		lista.add(cat1);
		lista.add(cat2);
		
		return lista;
	}
	
}
