package org.serratec.comercio.repository;

import java.util.List;

import org.serratec.comercio.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	List<Produto> findByNomeContainingIgnoreCase(String nome);
	
	List<Produto> findByCategoriaNome(String nomeCategoria);
	
	List<Produto> findByPrecoBetween(Double precoInicial, Double precoFinal);
}
