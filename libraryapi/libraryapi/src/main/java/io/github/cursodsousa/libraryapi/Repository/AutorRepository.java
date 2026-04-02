package io.github.cursodsousa.libraryapi.Repository;

import io.github.cursodsousa.libraryapi.Model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AutorRepository extends JpaRepository<Autor, UUID> {
}
