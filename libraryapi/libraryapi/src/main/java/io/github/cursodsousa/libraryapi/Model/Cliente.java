package io.github.cursodsousa.libraryapi.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


import java.util.UUID;

@Entity
@Data
public class Cliente {
    @Id
    private UUID id;
    @Column(nullable = false, length = 50)
    private String nome;
    @Column(nullable = false, length = 100)
    private String endereco;
    @Column(nullable = false, length = 50)
    private String cidade;
    @Column(nullable = false, length = 50)
    private String estado;
    @Embedded
    private Telephone telefone;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(nullable = false, length = 50, columnDefinition = "CHAR(11)")
    private String cpf;//criptografar esse atributo

}
