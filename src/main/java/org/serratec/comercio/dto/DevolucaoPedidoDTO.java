package org.serratec.comercio.dto;

import jakarta.validation.constraints.NotNull;

public class DevolucaoPedidoDTO {
    
    @NotNull(message = "O ID do pedido é obrigatório")
    private Long pedidoId;

    public DevolucaoPedidoDTO() {
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }
}