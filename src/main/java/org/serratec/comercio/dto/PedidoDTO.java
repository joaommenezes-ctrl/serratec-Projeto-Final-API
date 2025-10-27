package org.serratec.comercio.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.serratec.comercio.domain.Pedido;
import org.serratec.comercio.domain.StatusPedido;

public class PedidoDTO {

    private Long id;
    private LocalDateTime dataPedido;
    private StatusPedido statusPedido;
    private Long clienteId;
    private List<ItemPedidoDTO> itens;
    private double valorTotal = 0;

    public PedidoDTO() {
    }

    public PedidoDTO(Pedido pedido) {
        this.id = pedido.getId();
        this.dataPedido = pedido.getDataPedido();
        this.statusPedido = pedido.getStatusPedido();
        this.clienteId = pedido.getCliente().getId();

        if (pedido.getItens() != null) {
            this.itens = pedido.getItens().stream()
                    .map(ItemPedidoDTO::new)
                    .collect(Collectors.toList());
        } else {
            this.itens = List.of(); 
        }
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

    public double getValorTotal() {
        for(ItemPedidoDTO item: this.itens){
            valorTotal += item.getValorVenda() * item.getQuantidade();
        }
        return valorTotal;
    }
}
