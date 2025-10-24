package org.serratec.comercio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.serratec.comercio.domain.Avaliacao;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
}
