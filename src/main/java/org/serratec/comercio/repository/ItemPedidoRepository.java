package org.serratec.comercio.repository;

import java.util.List;

import org.serratec.comercio.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long>{

    List<ItemPedido> findByPedidoid(Long pedidoId);

    List<ItemPedido> findByProdutoid(Long produtoId);

}