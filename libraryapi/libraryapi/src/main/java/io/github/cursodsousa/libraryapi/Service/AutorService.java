package io.github.cursodsousa.libraryapi.Service;

import io.github.cursodsousa.libraryapi.DTO.AutorDTO;
import io.github.cursodsousa.libraryapi.Model.Autor;
import io.github.cursodsousa.libraryapi.Repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepos;
    public List<AutorDTO> search(String name){
        // Corrige: trim() remove espaços e isBlank() detecta strings vazias
        if(name == null || name.trim().isBlank()){
            System.out.println("Name is null or blank");
            return findAll();
        }
        System.out.println("Searching for: " + name);
        List<AutorDTO> autors = new ArrayList<>();
        autorRepos.findByNomeContainingIgnoreCase(name.trim()).forEach(autor ->
                autors.add(new AutorDTO(autor))
        );

        return autors;
    }
    public List<AutorDTO> findAll() {
        List<AutorDTO> autors = new ArrayList<>();
                autorRepos.findAll().forEach(autor -> autors.add(new AutorDTO(autor)) );
        return autors;
    }


}
