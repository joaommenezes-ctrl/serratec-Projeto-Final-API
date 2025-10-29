package org.serratec.comercio.dto;

import org.serratec.comercio.domain.Cliente;

public class ClienteDTO {
	private Long id;
	private String nome;
	private String cpf;
	private String telefone;
	private Long idusuario;
	private EnderecoDTO endereco;

	public ClienteDTO() {
	}

	public ClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		if (null != cliente.getEndereco()) {
			this.endereco = new EnderecoDTO(cliente.getEndereco());
		}
		this.telefone = cliente.getTelefone();
		if (cliente.getUsuario() != null) {
			this.idusuario = cliente.getUsuario().getId();
		}

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

	public Long getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
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
