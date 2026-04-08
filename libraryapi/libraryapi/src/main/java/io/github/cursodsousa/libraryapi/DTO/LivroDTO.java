package io.github.cursodsousa.libraryapi.DTO;

import io.github.cursodsousa.libraryapi.Model.Livro;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class LivroDTO {
    private UUID id;
    private String titulo;
    private String autor;

    public LivroDTO() {

    }

    public LivroDTO(UUID id, String autor, String titulo) {
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
    }


    public static LivroDTO conversorLivroDTO(Livro livro) {
        return new LivroDTO(livro.getId(),livro.getAutor().getNome(),livro.getTitulo());

    }
}
