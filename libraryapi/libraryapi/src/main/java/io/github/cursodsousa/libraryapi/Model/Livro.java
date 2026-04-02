package io.github.cursodsousa.libraryapi.Model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data//{@getter, @setter, toString, EqulsAndHAshCode, REquiredAngsConstrutor}
@NoArgsConstructor
@AllArgsConstructor
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(length = 20, nullable = false)
    private String isbn;
    @Column(length = 120, nullable = false)
    private String titulo;
    @ManyToOne
    @JoinColumn(name= "idAutor", nullable = false)
    private Autor autor;
    @Column(nullable = false)
    private LocalDate dataPublicacao;
    @Column(precision =18, scale = 2)
    private BigDecimal preco;
    @Enumerated(EnumType.STRING)
    @Column(length = 12)
    private GeneroLivro genero;


}
