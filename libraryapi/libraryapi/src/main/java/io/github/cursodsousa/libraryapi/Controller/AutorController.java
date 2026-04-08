package io.github.cursodsousa.libraryapi.Controller;

import io.github.cursodsousa.libraryapi.Repository.AutorRepository;
import io.github.cursodsousa.libraryapi.Service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Author")
public class AutorController {
@Autowired
    private AutorService autorServ;


     @GetMapping
    public ResponseEntity<?> search(
            @RequestParam(required = false) String nomeAutor){


        return ResponseEntity.ok(autorServ.search(nomeAutor));
    }


}
