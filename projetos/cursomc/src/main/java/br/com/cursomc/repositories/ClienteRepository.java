package br.com.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cursomc.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	//O SPRING IRÁ BUSCAR AUTOMATICAMENTE O EMAIL SÓ PELO NOME DO MÉTODO
	@Transactional(readOnly=true)
	Cliente findByEmail(String email);
}
