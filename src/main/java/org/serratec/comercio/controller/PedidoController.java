package org.serratec.comercio.controller;

import java.util.List;

import org.serratec.comercio.dto.PedidoDTO;
import org.serratec.comercio.dto.PedidoInserirDTO;
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
		List<PedidoDTO> pedidos = pedidoService.listarTodos();
		return ResponseEntity.ok(pedidos);
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
	public ResponseEntity<PedidoDTO> salvar(@RequestBody PedidoInserirDTO dto) {
		PedidoDTO pedidoSalvo = pedidoService.salvar(dto);
		return ResponseEntity.ok(pedidoSalvo);
	}

	@PutMapping("/{id}")
	public ResponseEntity<PedidoDTO> atualizar(@PathVariable Long id, @RequestBody PedidoInserirDTO dto) {
		try {
			PedidoDTO pedidoAtualizado = pedidoService.atualizar(id, dto);
			return ResponseEntity.ok(pedidoAtualizado);
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		pedidoService.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
