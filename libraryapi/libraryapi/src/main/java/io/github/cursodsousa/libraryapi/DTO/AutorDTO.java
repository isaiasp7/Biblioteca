package io.github.cursodsousa.libraryapi.DTO;

import io.github.cursodsousa.libraryapi.Model.Autor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class AutorDTO {
    private UUID id;
    private String nome;
    private List<LivroMinDTO> lista =new ArrayList<>();

    public AutorDTO(String nome, UUID id) {
        this.nome = nome;
        this.id = id;
    }
    public AutorDTO(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        autor.getLivros().forEach( book ->lista.add(new LivroMinDTO(book)) );


    }
}
