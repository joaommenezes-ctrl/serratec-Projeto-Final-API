package org.serratec.comercio.repository;

import java.util.List;

import org.serratec.comercio.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	List<Pedido> findByClienteId(Long clienteId);
	
	List<Pedido> findByStatus(String status);

}
