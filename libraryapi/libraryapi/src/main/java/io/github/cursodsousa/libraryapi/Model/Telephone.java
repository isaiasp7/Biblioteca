package io.github.cursodsousa.libraryapi.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable

public class Telephone {
    @Column(length = 3, nullable = false)
    private int ddd;
    @Column(length = 12, nullable = false)
    private int numero;

    public Telephone( int ddd, int numero) {
        this.ddd = ddd;
        this.numero = numero;
    }

    public Telephone() {

    }

    @Override
    public String toString() {
        return "Telefone : (" + ddd +
                ") " + numero;
    }
}
