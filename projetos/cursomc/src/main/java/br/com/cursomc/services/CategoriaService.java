package br.com.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cursomc.domain.Categoria;
import br.com.cursomc.repositories.CategoriaRepository;
import br.com.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public void salvarTodos(List<Categoria> listaCategorias) {
		categoriaRepository.saveAll(listaCategorias);
	}

	public Categoria insert(Categoria obj) {
		//TEM QUE SER NULO, SE NÃO ATUALIZA E NÃO INSERE
		obj.setId(null);
		return categoriaRepository.save(obj);
	}
	
	
}
