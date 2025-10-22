package org.serratec.comercio.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.serratec.comercio.domain.StatusPedido;

public class PedidoDTO {

    private Long id;
    private LocalDateTime dataPedido;
    private StatusPedido statusPedido;
    private Long clienteId;
    private List<Long> itensIds;

    public PedidoDTO() {}

    public PedidoDTO(Long id, LocalDateTime dataPedido, StatusPedido statusPedido, Long clienteId, List<Long> itensIds) {
        this.id = id;
        this.dataPedido = dataPedido;
        this.statusPedido = statusPedido;
        this.clienteId = clienteId;
        this.itensIds = itensIds;
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

    public List<Long> getItensIds() {
        return itensIds;
    }

    public void setItensIds(List<Long> itensIds) {
        this.itensIds = itensIds;
    }
}
