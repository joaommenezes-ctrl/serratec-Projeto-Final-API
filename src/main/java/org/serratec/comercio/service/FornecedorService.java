package org.serratec.comercio.service;

import java.util.List;
import java.util.Optional;

import org.serratec.comercio.domain.Fornecedor;
import org.serratec.comercio.dto.FornecedorDTO;
import org.serratec.comercio.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class FornecedorService {
	
	@Autowired
    private FornecedorRepository repository;

    public List<FornecedorDTO> listarTodos() {
        return repository.findAll().stream().map(FornecedorDTO::new).toList();
    }

    public FornecedorDTO buscarPorId(Long id) {
        Optional<Fornecedor> opt = repository.findById(id);
        return opt.map(FornecedorDTO::new).orElse(null);
    }

    public FornecedorDTO criar(Fornecedor fornecedor) {
        Fornecedor salvo = repository.save(fornecedor);
        return new FornecedorDTO(salvo);
    }

    public FornecedorDTO atualizar(Long id, Fornecedor fornecedor) {
        if (repository.existsById(id)) {
            fornecedor.setId(id);
            return new FornecedorDTO(repository.save(fornecedor));
        }
        return null;
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
	

}
