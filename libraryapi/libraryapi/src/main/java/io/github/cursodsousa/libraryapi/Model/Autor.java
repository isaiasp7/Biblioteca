package io.github.cursodsousa.libraryapi.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="Autor",schema = "public")
@Getter
@Setter
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(length = 180, nullable = false)
    private String nome;
    @Column(length = 50, nullable = false)
    private String nacionalidade;
    @OneToMany(mappedBy = "autor")
    private List<Livro> livros;
    @Deprecated
    public Autor() {//para uso do framework
         }

    public Autor(String nome, String nacionalidade) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }
}
