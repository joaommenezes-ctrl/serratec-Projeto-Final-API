package org.serratec.comercio.domain;

public enum Bandeira {
    VISA(1, "Visa"),
    MASTERCARD(2, "MasterCard"),
    AMEX(3, "American Express"),
    ELO(4, "Elo"),
    DINERS(5, "Diners");

    private final int id;
    private final String nome_bandeira;

    

    Bandeira(int id, String nome_bandeira) {
        this.id = id;
        this.nome_bandeira = nome_bandeira;
    }

    public int getId() {
        return id;
    }

    public String getNome_bandeira() {
        return nome_bandeira;
    }

}
