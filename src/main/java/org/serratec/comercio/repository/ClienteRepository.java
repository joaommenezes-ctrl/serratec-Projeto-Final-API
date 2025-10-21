package org.serratec.comercio.repository;

import org.serratec.comercio.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	Cliente findByEmail(String email);
	
	boolean existsByEmail(String email);
	
	boolean existsByCpf(String cpf);

}
