package org.serratec.comercio.repository;

import org.serratec.comercio.domain.Cupom;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CupomRepository extends JpaRepository<Cupom, Long> {
    Optional<Cupom> findByCodigo(String codigo);
}