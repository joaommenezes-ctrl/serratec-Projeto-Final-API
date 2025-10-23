package org.serratec.comercio.controller;

import java.util.List;

import org.serratec.comercio.domain.Cupom;
import org.serratec.comercio.service.CupomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cupons")
public class CupomController {

    @Autowired
    private CupomService service;

    @GetMapping
    public List<Cupom> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Cupom buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/codigo/{codigo}")
    public Cupom buscarPorCodigo(@PathVariable String codigo) {
        return service.buscarPorCodigo(codigo);
    }

    @PostMapping
    public Cupom criar(@RequestBody Cupom cupom) {
        return service.criar(cupom);
    }

    @PutMapping("/{id}")
    public Cupom atualizar(@PathVariable Long id, @RequestBody Cupom cupom) {
        return service.atualizar(id, cupom);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}