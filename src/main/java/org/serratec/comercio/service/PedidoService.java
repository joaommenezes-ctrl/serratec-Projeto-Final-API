package org.serratec.comercio.service;

import org.serratec.comercio.domain.Pedido;
import org.serratec.comercio.dto.PedidoDTO;
import org.serratec.comercio.repository.PedidoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {
    private PedidoRepository pedidoRepository;

    /* public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<PedidoDTO> listar() {
        return pedidoRepository.findAll()
                .stream()
                .map(PedidoDTO::new)
                .collect(Collectors.toList());
    }

    public PedidoDTO buscar(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado com ID: " + id));
        return new PedidoDTO(pedido);
    }

    public PedidoDTO salvar(PedidoDTO dto) {
        Pedido pedido = new Pedido();

        return new PedidoDTO(salvo);
    }

    public PedidoDTO atualizar(Long id, PedidoDTO dto) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado com ID: " + id));

        return new PedidoDTO(atualizado);
    }

    public void deletar(Long id) {
        if (!pedidoRepository.existsById(id)) {
            throw new RuntimeException("Pedido não encontrado com ID: " + id);
        }
        pedidoRepository.deleteById(id);
    } */
}
