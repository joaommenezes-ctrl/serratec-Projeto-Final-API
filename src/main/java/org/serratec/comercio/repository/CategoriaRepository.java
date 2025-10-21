package org.serratec.comercio.repository;

import org.serratec.comercio.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	Categoria findByNome(String nome);
}
