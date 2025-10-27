package org.serratec.comercio.service;

import java.util.List;
import java.util.stream.Collectors;

import org.serratec.comercio.domain.Categoria;
import org.serratec.comercio.dto.CategoriaDTO;
import org.serratec.comercio.exception.InvalidFieldException;
import org.serratec.comercio.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<CategoriaDTO> listar() {
        return categoriaRepository.findAll()
                .stream()
                .map(CategoriaDTO::new)
                .collect(Collectors.toList());
    }

    public CategoriaDTO buscar(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada com ID: " + id));
        return new CategoriaDTO(categoria);
    }

    public CategoriaDTO salvar(CategoriaDTO dto) throws InvalidFieldException {
        Categoria categoria = new Categoria();
        categoria.setNome(dto.getNome());
		try {
			categoriaRepository.save(categoria);
		} catch (RuntimeException e) {
			throw new InvalidFieldException("Erro ao salvar a categoria, " + "Não pode ser nulo ou vazio");
		}
        Categoria salvo = categoriaRepository.save(categoria);
        return new CategoriaDTO(salvo);
    }

    public CategoriaDTO atualizar(Long id, CategoriaDTO dto) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada com ID: " + id));
        categoria.setNome(dto.getNome());
        Categoria atualizado = categoriaRepository.save(categoria);
        return new CategoriaDTO(atualizado);
    }

    public void deletar(Long id) {
        if (!categoriaRepository.existsById(id)) {
            throw new RuntimeException("Categoria não encontrada com ID: " + id);
        }
        categoriaRepository.deleteById(id);
    }
}
