package io.github.cursodsousa.libraryapi.Repository;

import io.github.cursodsousa.libraryapi.Model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class LivroRepositoryTest {
    @Autowired
    private LivroRepository livroRepository;

    @Test
    void buscarLivroTeste(){
        UUID id = UUID.fromString("b0eebc99-9c0b-4ef8-bb6d-6bb9bd380b01");
        Livro livro = livroRepository.findById(id).orElse(null);
        System.out.println("=========================");
        System.out.println(livro);
    }

}