package io.github.cursodsousa.libraryapi.Service;

import io.github.cursodsousa.libraryapi.Model.Livro;
import io.github.cursodsousa.libraryapi.Repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepos;

    public List<String> findAllNames() {
        return livroRepos.findAll().stream().map(Livro::getTitulo).collect(Collectors.toList());
    }
}
