package org.serratec.comercio.controller;

import org.serratec.comercio.dto.CategoriaDTO;
import org.serratec.comercio.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> listar() {
        List<CategoriaDTO> categorias = categoriaService.listar();
        return ResponseEntity.ok(categorias);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> buscar(@PathVariable Long id){
        CategoriaDTO categoria = categoriaService.buscar(id);
        return ResponseEntity.ok(categoria);
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO>salvar(@RequestBody CategoriaDTO dto){
        CategoriaDTO categoriaSalva = categoriaService.salvar(dto);
        return ResponseEntity.ok(categoriaSalva);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> atualizar(@PathVariable Long id, @RequestBody CategoriaDTO dto){
        CategoriaDTO atualizado = categoriaService.atualizar(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        categoriaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
