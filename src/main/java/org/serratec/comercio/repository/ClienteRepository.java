package org.serratec.comercio.repository;

import java.util.Optional;

import org.serratec.comercio.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	Optional<Cliente> findByEmail(String email);
	
	boolean existsByEmail(String email);
	
	boolean existsByCpf(String cpf);

}
