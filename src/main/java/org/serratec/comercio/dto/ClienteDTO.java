package org.serratec.comercio.dto;

import org.serratec.comercio.domain.Cliente;

public class ClienteDTO {

    private String nome;
    private String cpf;
    private String telefone;

    public ClienteDTO() {}

    public ClienteDTO(Cliente cliente){
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.telefone = cliente.getTelefone();

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
