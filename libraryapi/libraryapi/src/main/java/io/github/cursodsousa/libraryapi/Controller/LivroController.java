package io.github.cursodsousa.libraryapi.Controller;

import io.github.cursodsousa.libraryapi.Service.LivroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Book")
public class LivroController {
    @Autowired
    private LivroService livroServ;
    @GetMapping
    public ResponseEntity<?> search(
            @RequestParam(required = false) String nomeAutor,
            @RequestParam(required = false) String nomeLivro) {


        return ResponseEntity.ok(livroServ.findAllNames());
    }

}
