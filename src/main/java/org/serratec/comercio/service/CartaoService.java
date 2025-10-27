package org.serratec.comercio.service;

import java.util.List;
import java.util.stream.Collectors;

import org.serratec.comercio.domain.Cartao;
import org.serratec.comercio.domain.Usuario;
import org.serratec.comercio.dto.CartaoDTO;
import org.serratec.comercio.exception.ClienteNaoAutorizadoException;
import org.serratec.comercio.exception.RecursoNaoEncontradoException;
import org.serratec.comercio.repository.CartaoRepository;
import org.serratec.comercio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CartaoService {
    @Autowired
    private CartaoRepository cartaoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    // Para fins de segurança, o usuário só poderá ver os próprios cartões
    /*
     * public List<CartaoDTO> listarTodos() {
     * return this.cartaoRepository.findAll().stream().map(CartaoDTO::new).collect(
     * Collectors.toList());
     * }
     */

    public List<CartaoDTO> listarPorClienteAutenticado() {
        // Lista apenas os cartões associados ao cliente associado
        String usuario_autenticado_email = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario usuario_autenticado = usuarioRepository.findByEmail(usuario_autenticado_email)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente autenticado não encontrado"));
        Long clienteId = usuario_autenticado.getCliente().getId();
        return this.cartaoRepository.findByClienteId(clienteId)
                .orElseThrow(
                        () -> new RecursoNaoEncontradoException("Não foi encontrado nenhum cartão para o cliente autenticado!"))
                .stream()
                .map(CartaoDTO::new)
                .collect(Collectors.toList());
    }

    public CartaoDTO buscarPorId(Long id) {
        // Verifica se o cartão a ser buscado é do cliente autenticado
        String usuario_autenticado_email = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario usuario_autenticado = usuarioRepository.findByEmail(usuario_autenticado_email)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente autenticado não encontrado"));
        Cartao cartao = this.cartaoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cartão não encontrado"));
        if (!cartao.getCliente().getId().equals(usuario_autenticado.getCliente().getId())) {
            throw new ClienteNaoAutorizadoException("Você não tem permissão para acessar esse recurso.");
        }
        return new CartaoDTO(cartao);
    }

    public CartaoDTO salvar(CartaoDTO cartaoDTO) {
        String usuario_autenticado_email = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario usuario_autenticado = usuarioRepository.findByEmail(usuario_autenticado_email)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente autenticado não encontrado"));

        Cartao cartao = new Cartao();
        cartao.setApelido(cartaoDTO.getApelido());
        cartao.setBandeira(cartaoDTO.getBandeira());
        cartao.setModalidade(cartaoDTO.getModalidade());
        cartao.setNumero(cartaoDTO.getNumero());
        cartao.setNomeImpresso(cartaoDTO.getNomeImpresso());
        cartao.setCvv(cartaoDTO.getCvv());
        cartao.setValidade(cartaoDTO.getValidade());
        cartao.setCliente(usuario_autenticado.getCliente());
        this.cartaoRepository.save(cartao);
        return new CartaoDTO(cartao);

    }

    public CartaoDTO atualizar(Long id, CartaoDTO cartaoDTO) {
        Cartao cartao = this.cartaoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cartão não encontrado"));
        // Verifica se o cartão a ser atualizado é do cliente autenticado
        String usuario_autenticado_email = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario usuario_autenticado = usuarioRepository.findByEmail(usuario_autenticado_email)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente autenticado não encontrado"));
        if (!cartao.getCliente().getId().equals(usuario_autenticado.getCliente().getId())) {
            throw new ClienteNaoAutorizadoException("Você não tem permissão para acessar esse recurso.");
        }
        cartao.setApelido(cartaoDTO.getApelido());
        cartao.setBandeira(cartaoDTO.getBandeira());
        cartao.setModalidade(cartaoDTO.getModalidade());
        cartao.setNumero(cartaoDTO.getNumero());
        cartao.setNomeImpresso(cartaoDTO.getNomeImpresso());
        cartao.setCvv(cartaoDTO.getCvv());
        cartao.setValidade(cartaoDTO.getValidade());
        this.cartaoRepository.save(cartao);
        return new CartaoDTO(cartao);

    }

    public void deletar(Long id) {
        Cartao cartao = cartaoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cartão não encontrado"));
        // Verifica se o cartão a ser deletado é do cliente autenticado
        String usuario_autenticado_email = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario usuario_autenticado = usuarioRepository.findByEmail(usuario_autenticado_email)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente autenticado não encontrado"));
        if (!cartao.getCliente().getId().equals(usuario_autenticado.getCliente().getId())) {
            throw new ClienteNaoAutorizadoException("Você não tem permissão para acessar esse recurso.");
        }

        this.cartaoRepository.deleteById(id);
    }

}
