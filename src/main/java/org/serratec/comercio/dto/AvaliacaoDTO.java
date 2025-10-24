package org.serratec.comercio.dto;

import java.time.LocalDate;

import org.serratec.comercio.domain.Avaliacao;

public class AvaliacaoDTO {
    private Long id;
    private Integer nota;
    private String comentario;
    private LocalDate data;
    private Long idProduto;
    private Long idCliente;

    public AvaliacaoDTO() {
    }

    public AvaliacaoDTO(Avaliacao avaliacao) {
        this.id = avaliacao.getId();
        this.nota = avaliacao.getNota();
        this.comentario = avaliacao.getComentario();
        this.data = avaliacao.getData();
        this.idProduto = avaliacao.getProduto().getId();
        this.idCliente = avaliacao.getCliente().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
}
