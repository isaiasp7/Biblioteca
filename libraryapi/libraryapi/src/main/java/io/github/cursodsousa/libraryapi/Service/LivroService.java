package io.github.cursodsousa.libraryapi.Service;

import io.github.cursodsousa.libraryapi.DTO.LivroDTO;
import io.github.cursodsousa.libraryapi.Model.GeneroLivro;
import io.github.cursodsousa.libraryapi.Model.Livro;
import io.github.cursodsousa.libraryapi.Repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepos;

    public List<LivroDTO> searchLivros(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            return findAll();
        }
        return null;
    }
    public List<String> findAllNames() {
        return livroRepos.findAll().stream().map(Livro::getTitulo).collect(Collectors.toList());
    }
    public List<LivroDTO> findAll() {
        List<LivroDTO> livros = new ArrayList<>();
        livroRepos.findAll().forEach(book->livros.add(LivroDTO.conversorLivroDTO(book)));
        return livros;
    }
    public GeneroLivro[] categorias() {
        return GeneroLivro.values();
    }
}
