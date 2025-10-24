package org.serratec.comercio.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.serratec.comercio.dto.AvaliacaoDTO;
import org.serratec.comercio.domain.Avaliacao;
import org.serratec.comercio.domain.Cliente;
import org.serratec.comercio.domain.Produto;
import org.serratec.comercio.repository.AvaliacaoRepository;
import org.serratec.comercio.repository.ClienteRepository;
import org.serratec.comercio.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoService {

    @Autowired
    AvaliacaoRepository avaliacaoRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    public List<AvaliacaoDTO> listarTodos() {
        return avaliacaoRepository.findAll().stream().map(AvaliacaoDTO::new).collect(Collectors.toList());
    }

    public AvaliacaoDTO buscarPorId(Long id) {
        Avaliacao avaliacao = avaliacaoRepository.findById(id).orElse(null);
        if (avaliacao == null) return null;
        return new AvaliacaoDTO(avaliacao);
    }

    public AvaliacaoDTO salvar(AvaliacaoDTO dto) {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setNota(dto.getNota());
        avaliacao.setComentario(dto.getComentario());
        avaliacao.setData(LocalDate.now());
        Produto produto = produtoRepository.findById(dto.getIdProduto()).orElse(null);
        Cliente cliente = clienteRepository.findById(dto.getIdCliente()).orElse(null);
        avaliacao.setProduto(produto);
        avaliacao.setCliente(cliente);
        avaliacaoRepository.save(avaliacao);
        return new AvaliacaoDTO(avaliacao);
    }

    public AvaliacaoDTO atualizar(Long id, AvaliacaoDTO dto) {
        Avaliacao avaliacao = avaliacaoRepository.findById(id).orElse(null);
        if (avaliacao == null) return null;
        avaliacao.setNota(dto.getNota());
        avaliacao.setComentario(dto.getComentario());
        avaliacaoRepository.save(avaliacao);
        return new AvaliacaoDTO(avaliacao);
    }

    public void deletar(Long id) {
        avaliacaoRepository.deleteById(id);
    }
}
