package org.serratec.comercio.dto;

import org.serratec.comercio.domain.Categoria;

public class CategoriaDTO {
    private String nome;

    public CategoriaDTO() {}


    public CategoriaDTO(Categoria categoria){
        this.nome = categoria.getNome();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
