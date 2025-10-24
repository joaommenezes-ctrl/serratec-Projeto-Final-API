package org.serratec.comercio.repository;

import java.util.List;

import org.serratec.comercio.domain.ItemPedido;
import org.serratec.comercio.domain.ItemPedidoPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPK> {

    List<ItemPedido> findByIdPedidoId(Long pedidoId);

    List<ItemPedido> findByIdProdutoId(Long produtoId);
}
