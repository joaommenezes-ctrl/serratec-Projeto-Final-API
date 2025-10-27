package org.serratec.comercio.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.YearMonth;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "É obrigatório informar um apelido para o cartão.")
    private String apelido;
    @Enumerated(EnumType.STRING)
    private Bandeira bandeira;
    @Enumerated(EnumType.STRING)
    private Modalidade modalidade;
    @NotBlank(message = "É obrigatório informar o número do cartão.")
    @Size(min = 16, max = 16, message = "O número do cartão deve conter 16 dígitos, e deve ser informado sem espaços")
    private String numero;
    @NotBlank(message = "É obrigatório informar o nome impresso no cartão.")
    private String nomeImpresso;
    @Min(value = 3, message = "O codigo de verificação deve conter no mínimo 3 dígitos.")
    private short cvv;
    private YearMonth validade;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @JsonBackReference
    private Cliente cliente;

    public Cartao() {
    }

    public Cartao(Long id, String apelido, Bandeira bandeira, String numero, String nomeImpresso, short cvv,
            YearMonth validade, Modalidade modalidade) {
        this.id = id;
        this.apelido = apelido;
        this.bandeira = bandeira;
        this.numero = numero;
        this.nomeImpresso = nomeImpresso;
        this.cvv = cvv;
        this.validade = validade;
        this.modalidade = modalidade;
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

    // Retorna apenas os últimos 4 dígitos do número do cartão
    public String getNumero() {
        return "************" + numero.substring(numero.length() - 4);
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

    public Modalidade getModalidade() {
        return modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
