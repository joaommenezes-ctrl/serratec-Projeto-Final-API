package org.serratec.comercio.domain;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Cupom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String codigo;

    @Column(nullable = false)
    private Double desconto; // porcentagem (ex: 10.0 = 10%)

    @Column(nullable = false)
    private LocalDate dataValidade;

    @Column(nullable = false)
    private Boolean ativo = true;

    public Cupom() {}

    public Cupom(String codigo, Double desconto, LocalDate dataValidade) {
        this.codigo = codigo;
        this.desconto = desconto;
        this.dataValidade = dataValidade;
        this.ativo = true;
    }

    public Long getId() { return id; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public Double getDesconto() { return desconto; }
    public void setDesconto(Double desconto) { this.desconto = desconto; }

    public LocalDate getDataValidade() { return dataValidade; }
    public void setDataValidade(LocalDate dataValidade) { this.dataValidade = dataValidade; }

    public Boolean getAtivo() { return ativo; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }
}
