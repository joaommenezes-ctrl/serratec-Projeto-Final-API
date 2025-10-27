package org.serratec.comercio.service;

import java.util.List;
import java.util.stream.Collectors;

import org.serratec.comercio.domain.Cliente;
import org.serratec.comercio.domain.Usuario;
import org.serratec.comercio.dto.ClienteDTO;
import org.serratec.comercio.exception.InvalidFieldException;
import org.serratec.comercio.repository.ClienteRepository;
import org.serratec.comercio.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;
	private final UsuarioRepository usuarioRepository;

	public ClienteService(ClienteRepository clienteRepository, UsuarioRepository usuarioRepository) {
		this.clienteRepository = clienteRepository;
		this.usuarioRepository = usuarioRepository;
	}

	public List<ClienteDTO> listar() {
		return clienteRepository.findAll().stream().map(ClienteDTO::new).collect(Collectors.toList());
	}

	public ClienteDTO buscar(Long id) {
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Cliente não encontrado com ID: " + id));
		return new ClienteDTO(cliente);
	}

	public ClienteDTO salvar(ClienteDTO dto) throws InvalidFieldException {
		Cliente cliente = new Cliente();
		cliente.setNome(dto.getNome());
		cliente.setCpf(dto.getCpf());
		cliente.setTelefone(dto.getTelefone());
		cliente.setRole("CLIENTE");

		if (dto.getIdusuario() != null) {
			Usuario usuario = usuarioRepository.findById(dto.getIdusuario())
					.orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + dto.getIdusuario()));
			cliente.setUsuario(usuario);
		}
		
		Cliente salvo;
		try {
			salvo = clienteRepository.save(cliente);
		} catch (RuntimeException e) {
			throw new InvalidFieldException("Erro ao salvar cliente, " + "Verifique os campos.");
		}

		return new ClienteDTO(salvo);
	}

	public ClienteDTO atualizar(Long id, ClienteDTO dto) {
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Cliente não encontrado com ID: " + id));
		cliente.setNome(dto.getNome());
		cliente.setCpf(dto.getCpf());
		cliente.setTelefone(dto.getTelefone());

		if (dto.getIdusuario() != null) {
			Usuario usuario = usuarioRepository.findById(dto.getIdusuario())
					.orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + dto.getIdusuario()));
			cliente.setUsuario(usuario);
		}

		Cliente atualizado = clienteRepository.save(cliente);
		return new ClienteDTO(atualizado);
	}

	public void deletar(Long id) {
		if (!clienteRepository.existsById(id)) {
			throw new RuntimeException("Cliente não encontrado com ID: " + id);
		}
		clienteRepository.deleteById(id);
	}
}
