package org.serratec.comercio.dto;

import org.serratec.comercio.domain.Cliente;

public class ClienteDTO {

    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Long idusuario;

    public ClienteDTO() {}

    public ClienteDTO(Cliente cliente){
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
        if (cliente.getUsuario() != null) {
            this.idusuario = cliente.getUsuario().getId();
        }

    }
    
	public Long getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}
	
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
