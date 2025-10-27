package org.serratec.comercio.repository;

import java.util.List;
import java.util.Optional;

import org.serratec.comercio.domain.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long> {
    Optional<List<Cartao>> findByClienteId(Long clienteId);
}
