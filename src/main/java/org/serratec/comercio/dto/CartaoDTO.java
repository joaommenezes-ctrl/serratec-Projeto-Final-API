package org.serratec.comercio.dto;

import java.time.YearMonth;

import org.serratec.comercio.domain.Bandeira;
import org.serratec.comercio.domain.Cartao;
import org.serratec.comercio.domain.Modalidade;

public class CartaoDTO {
    private Long id;
    private String apelido;
    private Bandeira bandeira;
    private Modalidade modalidade;
    private String numero;
    private String nomeImpresso;
    private short cvv;
    private YearMonth validade;
    private Long clienteId;

    public CartaoDTO() {
    }

    public CartaoDTO(Cartao cartao) {
        this.id = cartao.getId();
        this.apelido = cartao.getApelido();
        this.bandeira = cartao.getBandeira();
        this.modalidade = cartao.getModalidade();
        this.numero = cartao.getNumero();
        this.nomeImpresso = cartao.getNomeImpresso();
        this.cvv = cartao.getCvv();
        this.validade = cartao.getValidade();
        this.clienteId = cartao.getCliente().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public Bandeira getBandeira() {
        return bandeira;
    }

    public void setBandeira(Bandeira bandeira) {
        this.bandeira = bandeira;
    }

    public Modalidade getModalidade() {
        return modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNomeImpresso() {
        return nomeImpresso;
    }

    public void setNomeImpresso(String nomeImpresso) {
        this.nomeImpresso = nomeImpresso;
    }

    public short getCvv() {
        return cvv;
    }

    public void setCvv(short cvv) {
        this.cvv = cvv;
    }

    public YearMonth getValidade() {
        return validade;
    }

    public void setValidade(YearMonth validade) {
        this.validade = validade;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

}
