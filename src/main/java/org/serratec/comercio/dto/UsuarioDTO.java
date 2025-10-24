package org.serratec.comercio.dto;

import org.serratec.comercio.domain.Usuario;

public class UsuarioDTO {
	private Long id;
	private String email;
	private ClienteDTO cliente;
	
	public UsuarioDTO() {
	}
	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.email = usuario.getEmail();
		if (usuario.getCliente() != null) {
			this.cliente = new ClienteDTO(usuario.getCliente());
		}
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
	public ClienteDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	
	
}
