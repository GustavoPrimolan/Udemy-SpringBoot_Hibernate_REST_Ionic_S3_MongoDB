package br.com.cursomc.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cursomc.domain.Categoria;
import br.com.cursomc.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
	//COM A ANOTAÇÃO QUERY O FRAMEWORK FAZ A IMPLEMENTAÇÃO DO JPQL, SEM PRECISAR CRIAR UMA NOVA CLASSE
	//PARA JOGAR OS PARÂMETROS NAS VARÍAVEIS DO JPQL É APENAS NECESSÁRIO COLOCAR @PARAM
	//@Transactional(readOnly=true)
	//@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
	//Page<Produto> search(@Param("nome") String nome, @Param("categorias") List<Categoria> categorias, Pageable pageRequest);
	
	//ESSA LINHA FAZ A MESMA COISA QUE A LINHA DE CIMA
	//ELA É FEITA UTILIZANDO O PADRÃO DO SPRING, QUE CRIA O JPQL A PARTIR DO NOME DO MÉTODO
	//ELE DÁ PRIORIDADE PARA A QUERY
	//TRANSACTIONAL MOSTRA QUE NÃO É NECESSÁRIO FAZER UMA TRANSAÇÃO
	@Transactional(readOnly=true)
	Page<Produto> findDistinctByNomeContainingAndCategoriasIn(String nome, List<Categoria> categorias, Pageable pageRequest);
}
