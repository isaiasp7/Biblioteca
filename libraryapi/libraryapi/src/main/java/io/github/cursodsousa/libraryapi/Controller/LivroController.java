package io.github.cursodsousa.libraryapi.Controller;

import io.github.cursodsousa.libraryapi.DTO.LivroDTO;
import io.github.cursodsousa.libraryapi.Service.LivroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Book")
public class LivroController {
    @Autowired
    private LivroService livroServ;

    @GetMapping()
    public ResponseEntity<?> search(){
        List<LivroDTO> l = livroServ.findAll();

        return ResponseEntity.ok( l);

    }
    @GetMapping("categorias")
    public ResponseEntity<?> getCategoria(){
        return ResponseEntity.ok(livroServ.categorias());
    }

}
