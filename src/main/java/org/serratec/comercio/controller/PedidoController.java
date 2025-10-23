package org.serratec.comercio.controller;

import java.util.List;

import org.serratec.comercio.dto.PedidoDTO;
import org.serratec.comercio.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> listarTodos() {
        return ResponseEntity.ok(pedidoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> buscarPorId(@PathVariable Long id) {
        PedidoDTO pedido = pedidoService.buscarPorId(id);
        if (pedido == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pedido);
    }

    @PostMapping
    public ResponseEntity<PedidoDTO> salvar(@RequestBody PedidoDTO dto) {
        PedidoDTO novoPedido = pedidoService.salvar(dto);
        return ResponseEntity.ok(novoPedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pedidoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
