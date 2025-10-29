package org.serratec.comercio.controller;

import java.util.List;

import org.serratec.comercio.domain.Pedido;
import org.serratec.comercio.dto.DevolucaoPedidoDTO;
import org.serratec.comercio.dto.PedidoDTO;
import org.serratec.comercio.service.DevolucaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/devolucoes")
public class DevolucaoController {

    @Autowired
    private DevolucaoService devolucaoService;

    @PostMapping
    public ResponseEntity<PedidoDTO> processarDevolucao(@Valid @RequestBody DevolucaoPedidoDTO devolucaoDTO) {
        PedidoDTO pedidoDevolvido = devolucaoService.processarDevolucao(devolucaoDTO);
        return ResponseEntity.ok(pedidoDevolvido);
    }

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> listarDevolucoes() {
        List<PedidoDTO> devolucoes = devolucaoService.listarDevolucoes();
        return ResponseEntity.ok(devolucoes);
    }
}