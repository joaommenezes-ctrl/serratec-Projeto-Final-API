package org.serratec.comercio.dto;

import org.serratec.comercio.domain.ItemPedido;

public class ItemPedidoDTO {
	private Long id;
	private Integer quantidade;
	private Double ValorVenda;

	public ItemPedidoDTO() {
	}

	public ItemPedidoDTO(Long id, Integer quantidade, Double ValorVenda) {
		this.id = id;
		this.quantidade = quantidade;
		this.ValorVenda = ValorVenda;
	}

	public ItemPedidoDTO(ItemPedido itemPedido) {
		this.id = itemPedido.getId().getProduto().getId();
		this.quantidade = itemPedido.getQuantidade();
		this.ValorVenda = itemPedido.getValorVenda();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorVenda() {
		return ValorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		ValorVenda = valorVenda;
	}

}
