package org.serratec.comercio.domain;


import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class UsuarioCliente {

	@EmbeddedId
	private UsuarioClientePK id = new UsuarioClientePK();

	@Column(name = "data_criacao")
	private LocalDate dataCriacao;
	

	public UsuarioCliente() {}

	public UsuarioCliente(Usuario usuario, Cliente cliente, LocalDate dataCriacao) {
		this.id.setUsuario(usuario);
		this.id.setCliente(cliente);
		this.dataCriacao = dataCriacao;
	}

	public UsuarioClientePK getId() {
		return id;
	}

	public void setId(UsuarioClientePK id) {
		this.id = id;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

}
