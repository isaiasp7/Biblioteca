package io.github.cursodsousa.libraryapi.Repository;


import io.github.cursodsousa.libraryapi.DTO.AutorDTO;
import io.github.cursodsousa.libraryapi.Model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AutorRepository extends JpaRepository<Autor, UUID> {



    List<Autor> findByNomeContainingIgnoreCase(String nome);
}
