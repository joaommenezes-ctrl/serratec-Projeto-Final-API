package org.serratec.comercio.repository;

import java.util.Optional;

import org.serratec.comercio.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
    Optional<Usuario> findByEmail(String email);
}
