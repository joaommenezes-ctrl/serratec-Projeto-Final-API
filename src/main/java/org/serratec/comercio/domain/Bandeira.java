package org.serratec.comercio.domain;

public enum Bandeira {
    VISA(1, "Visa"),
    MASTERCARD(2, "MasterCard"),
    AMEX(3, "American Express"),
    ELO(4, "Elo"),
    DINERS(5, "Diners");

    private final int codigo;
    private final String nome;

    Bandeira(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

}
