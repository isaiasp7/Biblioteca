package io.github.cursodsousa.libraryapi.Repository;

import io.github.cursodsousa.libraryapi.Model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID> {
}
