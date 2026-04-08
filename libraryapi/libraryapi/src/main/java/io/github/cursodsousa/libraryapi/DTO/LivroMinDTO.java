package io.github.cursodsousa.libraryapi.DTO;

import io.github.cursodsousa.libraryapi.Model.Livro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LivroMinDTO {
    private UUID id;
    private String titulo;

    public LivroMinDTO(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }
}
