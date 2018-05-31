package br.com.cursomc.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.cursomc.domain.Categoria;
import br.com.cursomc.dto.CategoriaDTO;
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
	public ResponseEntity<Categoria> find(@PathVariable Integer id) {
		Categoria obj = categoriaService.find(id);
		
		//RESPOSTA OK E O OBJETO NO CORPO
		return ResponseEntity.ok().body(obj);
	}
	
	//RESPOSTA COM O CORPO VAZIO
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CategoriaDTO objDto){
		Categoria obj = categoriaService.fromDTO(objDto);
		obj = categoriaService.insert(obj);
		//DÁ UM GET PARA PEGAR A O ID DO OBJETO SALVO
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody CategoriaDTO objDto, @PathVariable Integer id){
		Categoria obj = categoriaService.fromDTO(objDto);
		obj.setId(id);
		obj = categoriaService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		categoriaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<CategoriaDTO>> findAll(){
		List<Categoria> list = categoriaService.findAll();
		List<CategoriaDTO> listDto = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	//PARAMETROS NO REQUEST E SÃO OPCIONAIS
	//PQ 24 LINHA POR PÁGINA? POIS É FÁCIL DE COLOCAR NO LAYOUT PQ É MULTIPLO DE 4
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<CategoriaDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC")String direction){
		
		Page<Categoria> list = categoriaService.findPage(page, linesPerPage, orderBy, direction);
		Page<CategoriaDTO> listDto = list.map(obj -> new CategoriaDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
	
}
