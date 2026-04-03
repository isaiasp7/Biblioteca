package io.github.cursodsousa.libraryapi.DTO;

import java.util.UUID;

public class AutorDTO {
    private UUID id;
    private String nome;

    public AutorDTO(String nome, UUID id) {
        this.nome = nome;
        this.id = id;
    }
}
