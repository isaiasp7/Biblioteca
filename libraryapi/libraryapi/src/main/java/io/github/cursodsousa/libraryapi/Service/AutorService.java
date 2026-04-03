package io.github.cursodsousa.libraryapi.Service;

import io.github.cursodsousa.libraryapi.Repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepos;


}
