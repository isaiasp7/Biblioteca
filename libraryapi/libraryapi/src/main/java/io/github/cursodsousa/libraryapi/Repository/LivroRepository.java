package io.github.cursodsousa.libraryapi.Repository;

import io.github.cursodsousa.libraryapi.Model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface LivroRepository extends JpaRepository<Livro, UUID> {
}
