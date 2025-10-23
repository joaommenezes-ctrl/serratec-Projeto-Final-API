package org.serratec.comercio.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.serratec.comercio.domain.Pedido;
import org.serratec.comercio.domain.Cliente;
import org.serratec.comercio.domain.ItemPedido;
import org.serratec.comercio.dto.PedidoDTO;
import org.serratec.comercio.repository.PedidoRepository;
import org.serratec.comercio.repository.ClienteRepository;
import org.serratec.comercio.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public List<PedidoDTO> listarTodos() {
        return pedidoRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public PedidoDTO buscarPorId(Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        return pedido.map(this::toDTO).orElse(null);
    }

    public PedidoDTO salvar(PedidoDTO dto) {
        Pedido pedido = new Pedido();
        pedido.setDataPedido(dto.getDataPedido());
        pedido.setStatusPedido(dto.getStatusPedido());

        if (dto.getClienteId() != null) {
            Cliente cliente = clienteRepository.findById(dto.getClienteId()).orElse(null);
            pedido.setCliente(cliente);
        }

        if (dto.getItensIds() != null) {
            List<ItemPedido> itens = itemPedidoRepository.findAllById(dto.getItensIds());
            pedido.setItens(itens);
        }

        pedidoRepository.save(pedido);
        return toDTO(pedido);
    }

    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }

    private PedidoDTO toDTO(Pedido pedido) {
        List<Long> itensIds = pedido.getItens() != null
                ? pedido.getItens().stream().map(ItemPedido::getId).collect(Collectors.toList())
                : null;

        Long clienteId = pedido.getCliente() != null ? pedido.getCliente().getId() : null;

        return new PedidoDTO(
                pedido.getId(),
                pedido.getDataPedido(),
                pedido.getStatusPedido(),
                clienteId,
                itensIds
        );
    }
}
