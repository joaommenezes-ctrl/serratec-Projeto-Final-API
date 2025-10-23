package org.serratec.comercio.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.serratec.comercio.domain.StatusPedido;

public class PedidoInserirDTO {

    private LocalDateTime dataPedido;
    private StatusPedido statusPedido;
    private Long clienteId;
    private List<ItemPedidoInserirDTO> itens;

    public PedidoInserirDTO() {
    }

    public PedidoInserirDTO(LocalDateTime dataPedido, StatusPedido statusPedido, Long clienteId,
                            List<ItemPedidoInserirDTO> itens) {
        this.dataPedido = dataPedido;
        this.statusPedido = statusPedido;
        this.clienteId = clienteId;
        this.itens = itens;
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

    public List<ItemPedidoInserirDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoInserirDTO> itens) {
        this.itens = itens;
    }
}
