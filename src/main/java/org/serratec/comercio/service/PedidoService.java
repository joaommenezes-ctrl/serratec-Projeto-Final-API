package org.serratec.comercio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.serratec.comercio.domain.Pedido;
import org.serratec.comercio.domain.Cliente;
import org.serratec.comercio.domain.ItemPedido;
import org.serratec.comercio.domain.Produto;
import org.serratec.comercio.dto.PedidoDTO;
import org.serratec.comercio.dto.PedidoInserirDTO;
import org.serratec.comercio.dto.ItemPedidoInserirDTO;
import org.serratec.comercio.repository.PedidoRepository;
import org.serratec.comercio.repository.ClienteRepository;
import org.serratec.comercio.repository.ItemPedidoRepository;
import org.serratec.comercio.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<PedidoDTO> listarTodos() {
        return pedidoRepository.findAll()
                .stream()
                .map(PedidoDTO::new)
                .collect(Collectors.toList());
    }

    public PedidoDTO buscarPorId(Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        return pedido.map(PedidoDTO::new).orElse(null);
    }

    @Transactional
    public PedidoDTO salvar(PedidoInserirDTO dto) {
        Pedido pedido = new Pedido();
        pedido.setDataPedido(dto.getDataPedido());
        pedido.setStatusPedido(dto.getStatusPedido());

        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        pedido.setCliente(cliente);

        List<ItemPedido> itens = new ArrayList<>();

        if (dto.getItens() != null && !dto.getItens().isEmpty()) {
            for (ItemPedidoInserirDTO itemDTO : dto.getItens()) {

                Produto produto = produtoRepository.findById(itemDTO.getProdutoId())
                        .orElseThrow(() -> new RuntimeException("Produto não encontrado: " + itemDTO.getProdutoId()));

                ItemPedido item = new ItemPedido(
                        pedido,
                        produto,
                        itemDTO.getQuantidade(),
                        itemDTO.getValorVenda()
                );

                itens.add(item);
            }
        }

        pedido.setItens(itens);

        pedido = pedidoRepository.save(pedido);

        for (ItemPedido item : itens) {
            itemPedidoRepository.save(item);
        }

        return new PedidoDTO(pedido);
    }

    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }
}
