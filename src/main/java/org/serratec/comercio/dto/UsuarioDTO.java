package org.serratec.comercio.dto;

import org.serratec.comercio.domain.Usuario;

public class UsuarioDTO {
	private Long id;
	private String nome;
	private String email;
	
	public UsuarioDTO() {
	}
	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
//	public ClienteDTO getCliente() {
//		return cliente;
//	}
//	public void setCliente(ClienteDTO cliente) {
//		this.cliente = cliente;
//	}
	
	
}
