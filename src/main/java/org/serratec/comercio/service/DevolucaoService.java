package org.serratec.comercio.service;

import java.util.List;
import java.util.stream.Collectors;

import org.serratec.comercio.domain.Pedido;
import org.serratec.comercio.domain.StatusPedido;
import org.serratec.comercio.domain.Usuario;
import org.serratec.comercio.dto.DevolucaoPedidoDTO;
import org.serratec.comercio.dto.PedidoDTO;
import org.serratec.comercio.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class DevolucaoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido processarDevolucao(DevolucaoPedidoDTO devolucaoDTO) {
        Usuario usuarioLogado = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        Pedido pedido = pedidoRepository.findById(devolucaoDTO.getPedidoId())
            .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        if (!pedido.getCliente().getUsuario().getId().equals(usuarioLogado.getId())) {
            throw new RuntimeException("Este pedido não pertence ao usuário logado");
        }

        if (!pedido.getStatusPedido().equals(StatusPedido.ENTREGUE)) {
            throw new RuntimeException("Apenas pedidos entregues podem ser devolvidos");
        }

        pedido.setStatusPedido(StatusPedido.DEVOLVIDO);
        return pedidoRepository.save(pedido);
    }

    public List<PedidoDTO> listarDevolucoes() {
        Usuario usuarioLogado = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long clienteId = usuarioLogado.getCliente().getId();
        List<Pedido> devolucoes = pedidoRepository.findByClienteIdAndStatusPedido(clienteId, StatusPedido.DEVOLVIDO);
        return devolucoes.stream().map(PedidoDTO::new).collect(Collectors.toList());
    }
}