package org.serratec.comercio.domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Usuario implements UserDetails, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nome;

	@Column
	private String email;

	@Column
	private String senha;
	
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Cliente cliente;


	public Usuario() {
	}

	public Usuario(Long id, String nome, String email, String senha) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return email;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	    List<GrantedAuthority> authorities = new ArrayList<>();
	    if (cliente != null && cliente.getRole() != null) {
	        String role = cliente.getRole().toUpperCase();
	        if (!role.startsWith("ROLE_")) {
	            role = "ROLE_" + role;
	        }
	        authorities.add(new SimpleGrantedAuthority(role));
	    }
	    return authorities;
	}

}
