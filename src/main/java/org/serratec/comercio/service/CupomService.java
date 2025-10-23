package org.serratec.comercio.service;

import java.time.LocalDate;
import java.util.List;

import org.serratec.comercio.domain.Cupom;
import org.serratec.comercio.repository.CupomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CupomService {

    @Autowired
    private CupomRepository repository;

    public List<Cupom> listarTodos() {
        return repository.findAll();
    }

    public Cupom buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cupom não encontrado"));
    }

    public Cupom criar(Cupom cupom) {
        if (cupom.getDataValidade().isBefore(LocalDate.now())) {
            throw new RuntimeException("Data de validade inválida");
        }
        return repository.save(cupom);
    }

    public Cupom atualizar(Long id, Cupom novo) {
        Cupom existente = buscarPorId(id);
        existente.setCodigo(novo.getCodigo());
        existente.setDesconto(novo.getDesconto());
        existente.setDataValidade(novo.getDataValidade());
        existente.setAtivo(novo.getAtivo());
        return repository.save(existente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Cupom buscarPorCodigo(String codigo) {
        return repository.findByCodigo(codigo)
                .orElseThrow(() -> new RuntimeException("Cupom não encontrado"));
    }
}
