package org.serratec.comercio.controller;


import org.serratec.comercio.dto.CategoriaDTO;
import org.serratec.comercio.service.ProdutoService;
import org.serratec.comercio.dto.ProdutoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listar(){
        List<ProdutoDTO> produtos = produtoService.listar();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> buscar(@PathVariable Long id){
        ProdutoDTO produto = produtoService.buscar(id);
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO>salvar (@RequestBody ProdutoDTO dto){
        ProdutoDTO produtoSalvo = produtoService.salvar(dto);
        return ResponseEntity.ok(produtoSalvo);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> atualizar(@PathVariable Long id, @RequestBody ProdutoDTO dto){
        ProdutoDTO atualizado = produtoService.atualizar(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
