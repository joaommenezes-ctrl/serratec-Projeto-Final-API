package org.serratec.comercio.dto;

import org.serratec.comercio.domain.Produto;

import java.math.BigDecimal;

public class ProdutoDTO {
    private String nome;
    private String descricao;
    private BigDecimal preco;

    public ProdutoDTO() {}


    public ProdutoDTO(Produto produto){
        this.nome = produto.getNome();
        this.descricao= produto.getDescricao();
        this.preco = produto.getPreco();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
