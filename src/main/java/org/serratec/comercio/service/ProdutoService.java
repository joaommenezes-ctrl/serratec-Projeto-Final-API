package org.serratec.comercio.service;

import java.util.List;
import java.util.stream.Collectors;

import org.serratec.comercio.domain.Categoria;
import org.serratec.comercio.domain.Produto;
import org.serratec.comercio.dto.ProdutoDTO;
import org.serratec.comercio.exception.InvalidFieldException;
import org.serratec.comercio.repository.CategoriaRepository;
import org.serratec.comercio.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
	@Autowired
    private ProdutoRepository produtoRepository;
    
	@Autowired
    private CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<ProdutoDTO> listar() {
        List<ProdutoDTO> produtosDTO = produtoRepository
                .findAll()
                .stream()
                .map(ProdutoDTO::new)
                .collect(Collectors.toList());
        return produtosDTO;
    }

    public ProdutoDTO buscar(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + id));
        return new ProdutoDTO(produto);
    }

    public ProdutoDTO salvar(ProdutoDTO dto) throws InvalidFieldException {
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());
        
		Categoria categoria = categoriaRepository.findById(dto.getIdCategoria())
				.orElseThrow(() -> new RuntimeException("Categoria não encontrada com ID: " + dto.getIdCategoria()));
        	
		produto.setCategoria(categoria);
		
        try {
        	produto = produtoRepository.save(produto);
		} catch (RuntimeException e) {
			throw new InvalidFieldException("Erro ao salvar produto, " + "Verifique os campos obrigatórios.");
		}
        return new ProdutoDTO(produto);
    }

    public ProdutoDTO atualizar(Long id, ProdutoDTO dto) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + id));
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());
        
        Categoria categoria = categoriaRepository.findById(dto.getIdCategoria())
				.orElseThrow(() -> new RuntimeException("Categoria não encontrada com ID: " + dto.getIdCategoria()));
        	
		produto.setCategoria(categoria);
		
        Produto atualizado = produtoRepository.save(produto);
        return new ProdutoDTO(atualizado);
    }

    public void deletar(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado com ID: " + id);
        }
        produtoRepository.deleteById(id);
    }
}
