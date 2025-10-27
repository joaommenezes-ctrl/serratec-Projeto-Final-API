package org.serratec.comercio.repository;

import java.util.List;

import org.serratec.comercio.domain.Pedido;
import org.serratec.comercio.domain.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	List<Pedido> findByClienteId(Long clienteId);
	
	List<Pedido> findByStatusPedido(StatusPedido statusPedido);

	List<Pedido> findByClienteIdAndStatusPedido(Long clienteId, StatusPedido status);

}
