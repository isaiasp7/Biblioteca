package io.github.cursodsousa.libraryapi.DTO;

import java.util.List;
import java.util.UUID;

// DTO para resposta
public class AutorLivrosDTO {
    private UUID id;
    private String nome;
    private List<String> titulosLivros;  // Apenas os títulos

    public AutorLivrosDTO(UUID id, String nome, List<String> titulosLivros) {
        this.id = id;
        this.nome = nome;
        this.titulosLivros = titulosLivros;
    }

    // Getters e Setters
}
