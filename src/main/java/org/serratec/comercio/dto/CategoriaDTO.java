package org.serratec.comercio.dto;

import org.serratec.comercio.domain.Categoria;

public class CategoriaDTO {
	
	private Long id;
	
    private String nome;

    public CategoriaDTO() {}


    public CategoriaDTO(Categoria categoria){
        this.nome = categoria.getNome();
        this.id = categoria.getId();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
    
    
}
