package org.serratec.comercio.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.serratec.comercio.domain.Pedido;
import org.serratec.comercio.domain.Produto;
import org.serratec.comercio.domain.StatusPedido;

public class PedidoDTO {

    private Long id;
    private LocalDateTime dataPedido;
    private StatusPedido statusPedido;
    private Long clienteId;
    private List<ItemPedidoDTO> itens;
    private List <Produto> produtos;

    public PedidoDTO() {}

    public PedidoDTO(Pedido pedido) {
        this.id = pedido.getId();
        this.dataPedido = pedido.getDataPedido();
        this.statusPedido = pedido.getStatusPedido();
        this.clienteId = pedido.getCliente().getId();
        this.itens = pedido.getItens()
                .stream()
                .map(ItemPedidoDTO::new)
                .toList();
        this.produtos = pedido.getProdutos();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public List<ItemPedidoDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoDTO> itens) {
        this.itens = itens;
    }

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
    
}
