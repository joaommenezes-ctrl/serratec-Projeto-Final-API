package org.serratec.comercio.controller;

import java.util.List;

import org.serratec.comercio.domain.Fornecedor;
import org.serratec.comercio.dto.FornecedorDTO;
import org.serratec.comercio.service.FornecedorService;
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
@RequestMapping("/fornecedores")
public class FornecedorController {
	
	@Autowired
    private FornecedorService service;

    @GetMapping
    public ResponseEntity<List<FornecedorDTO>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedorDTO> buscar(@PathVariable Long id) {
        FornecedorDTO dto = service.buscarPorId(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<FornecedorDTO> criar(@RequestBody Fornecedor fornecedor) {
        return ResponseEntity.ok(service.criar(fornecedor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FornecedorDTO> atualizar(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
        FornecedorDTO dto = service.atualizar(id, fornecedor);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
