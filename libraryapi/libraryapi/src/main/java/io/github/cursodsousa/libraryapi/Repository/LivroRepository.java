package io.github.cursodsousa.libraryapi.Repository;

import io.github.cursodsousa.libraryapi.Model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface LivroRepository extends JpaRepository<Livro, UUID> {

    @Query("SELECT DISTINCT l.genero FROM Livro l")
    List<String> listarGenerosDisponiveis();
}
