package org.serratec.comercio.controller;

import java.util.List;

import org.serratec.comercio.dto.CartaoDTO;
import org.serratec.comercio.service.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    /*
     * @GetMapping
     * public ResponseEntity<List<CartaoDTO>> listarTodos() {
     * return ResponseEntity.ok(cartaoService.listarTodos());
     * }
     */

    @GetMapping
    public ResponseEntity<List<CartaoDTO>> buscarPorClienteAutenticado() {
        return ResponseEntity.ok(cartaoService.listarPorClienteAutenticado());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartaoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cartaoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<CartaoDTO> salvar(@RequestBody CartaoDTO cartaoDTO) {
        return ResponseEntity.ok(cartaoService.salvar(cartaoDTO));
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartaoDTO> atualizar(@PathVariable Long id, @RequestBody CartaoDTO cartaoDTO) {
        return ResponseEntity.ok(cartaoService.salvar(cartaoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        cartaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
