package org.serratec.comercio.dto;

public class ItemPedidoInserirDTO {
	private Long produtoId;
	private Integer quantidade;
	private Double valorVenda;
	
	
	public ItemPedidoInserirDTO() {}
	
	public ItemPedidoInserirDTO(Long produtoId, Integer quantidade, Double valorVenda) {
		this.produtoId = produtoId;
		this.quantidade = quantidade;
		this.valorVenda = valorVenda;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Long getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
