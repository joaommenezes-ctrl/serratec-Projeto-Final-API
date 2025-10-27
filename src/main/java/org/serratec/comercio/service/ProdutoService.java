package org.serratec.comercio.service;

import java.util.List;
import java.util.stream.Collectors;

import org.serratec.comercio.domain.Produto;
import org.serratec.comercio.dto.ProdutoDTO;
import org.serratec.comercio.exception.InvalidFieldException;
import org.serratec.comercio.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

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
        Produto salvo;
        try {
        	salvo = produtoRepository.save(produto);
		} catch (RuntimeException e) {
			throw new InvalidFieldException("Erro ao salvar produto, " + "Verifique os campos obrigatórios.");
		}
        salvo = produtoRepository.save(produto);
        return new ProdutoDTO(salvo);
    }

    public ProdutoDTO atualizar(Long id, ProdutoDTO dto) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + id));
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());
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
