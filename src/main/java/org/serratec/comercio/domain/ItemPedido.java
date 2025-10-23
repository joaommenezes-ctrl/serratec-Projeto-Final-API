package org.serratec.comercio.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class ItemPedido {

    @EmbeddedId
    private ItemPedidoPK id = new ItemPedidoPK();

    private Integer quantidade;
    private Double valorVenda;

    public ItemPedido() {}

    public ItemPedido(ItemPedidoPK id, Integer quantidade, Double valorVenda) {
        this.id = id;
        this.quantidade = quantidade;
        this.valorVenda = valorVenda;
    }

    public ItemPedido(Pedido pedido, Produto produto, Integer quantidade, Double valorVenda) {
        this.id.setPedido(pedido);
        this.id.setProduto(produto);
        this.quantidade = quantidade;
        this.valorVenda = valorVenda;
    }

    public ItemPedidoPK getId() {
        return id;
    }

    public void setId(ItemPedidoPK id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Pedido getPedido() {
        return id.getPedido();
    }

    public Produto getProduto() {
        return id.getProduto();
    }
}
