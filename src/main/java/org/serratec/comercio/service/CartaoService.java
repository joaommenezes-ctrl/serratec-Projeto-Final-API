package org.serratec.comercio.service;

import java.util.List;
import java.util.stream.Collectors;

import org.serratec.comercio.domain.Cartao;
import org.serratec.comercio.domain.Cliente;
import org.serratec.comercio.dto.CartaoDTO;
import org.serratec.comercio.repository.CartaoRepository;
import org.serratec.comercio.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

public class CartaoService {
    @Autowired
    private CartaoRepository cartaoRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    // Para fins de segurança, o usuário só poderá ver os próprios cartões
    /* public List<CartaoDTO> listarTodos() {
        return this.cartaoRepository.findAll().stream().map(CartaoDTO::new).collect(Collectors.toList());
    } */

    public List<CartaoDTO> listarPorClienteAutenticado() {
        String cliente_autenticado_email = SecurityContextHolder.getContext().getAuthentication().getName();
        Cliente cliente_autenticado = clienteRepository.findByEmail(cliente_autenticado_email)
            .orElseThrow(() -> new RuntimeException("Cliente autenticado não encontrado"));
        Long clienteId = cliente_autenticado.getId();
        return this.cartaoRepository.findByClienteId(clienteId)
            .orElseThrow(() -> new RuntimeException("Não foi encontrado nnenhum cartão para o cliente autenticado!"))
            .stream()
            .map(CartaoDTO::new)
            .collect(Collectors.toList());
    }

    /* public CartaoDTO buscarPorId(Long id) {
        return new CartaoDTO(this.cartaoRepository.findById(id).orElse(null));
    } */

    public CartaoDTO salvar(CartaoDTO cartaoDTO) {
        String cliente_autenticado_email = SecurityContextHolder.getContext().getAuthentication().getName();
        Cliente cliente_autenticado = clienteRepository.findByEmail(cliente_autenticado_email)
            .orElseThrow(() -> new RuntimeException("Cliente autenticado não encontrado"));
        Cartao cartao = new Cartao();
        cartao.setApelido(cartaoDTO.getApelido());
        cartao.setBandeira(cartaoDTO.getBandeira());
        cartao.setModalidade(cartaoDTO.getModalidade());
        cartao.setNumero(cartaoDTO.getNumero());
        cartao.setNomeImpresso(cartaoDTO.getNomeImpresso());
        cartao.setCvv(cartaoDTO.getCvv());
        cartao.setValidade(cartaoDTO.getValidade());
        cartao.setCliente(cliente_autenticado);
        this.cartaoRepository.save(cartao);
        return new CartaoDTO(cartao);

    }

    public CartaoDTO atualizar(Long id, CartaoDTO cartaoDTO) {
        Cartao cartao = this.cartaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Cartão não encontrado"));
        // Verifica se o cartão a ser atualizado é do cliente autenticado
        String cliente_autenticado_email = SecurityContextHolder.getContext().getAuthentication().getName();
        Cliente cliente_autenticado = clienteRepository.findByEmail(cliente_autenticado_email)
            .orElseThrow(() -> new RuntimeException("Cliente autenticado não encontrado"));
        if(!cartao.getCliente().getId().equals(cliente_autenticado.getId())){
            throw new RuntimeException("Você não tem permissão para acessar esse recurso.");
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
            .orElseThrow(() -> new RuntimeException("Cartão não encontrado"));
        // Verifica se o cartão a ser deletado é do cliente autenticado
        String cliente_autenticado_email = SecurityContextHolder.getContext().getAuthentication().getName();
        Cliente cliente_autenticado = clienteRepository.findByEmail(cliente_autenticado_email)
            .orElseThrow(() -> new RuntimeException("Cliente autenticado não encontrado"));
        if(!cartao.getCliente().getId().equals(cliente_autenticado.getId())){
            throw new RuntimeException("Você não tem permissão para acessar esse recurso.");
        }

        this.cartaoRepository.deleteById(id);
    }

    

    

}
