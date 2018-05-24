package br.com.cursomc.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.cursomc.domain.Categoria;
import br.com.cursomc.services.CategoriaService;

//CONTROLADOR REST E RESPONDERÁ PELO END POINT /CATEGORIAS
@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService;
	
	//CAIRÁ AQUI QUANDO UTILIZAR O /categorias NO GET
	//O ResponseEntity ENCAPSULA VÁRIAS INFORMAÇÕES DE UMA RESPOSTA HTTP PARA O SERVIÇO REST
	//O PARÂMETRO {id} SERÁ JOGADO NA VARIÁVEL id, POR CONTA DISSO É NECESSÁRIO A ANOTAÇÃO @PathVariable
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria obj = categoriaService.buscar(id);
		
		//RESPOSTA OK E O OBJETO NO CORPO
		return ResponseEntity.ok().body(obj);
	}
	
	//RESPOSTA COM O CORPO VAZIO
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Categoria obj){
		obj = categoriaService.insert(obj);
		//DÁ UM GET PARA PEGAR A O ID DO OBJETO SALVO
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
}
