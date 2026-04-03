package io.github.cursodsousa.libraryapi.Controller;

import io.github.cursodsousa.libraryapi.Repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Author")
public class AutorController {
@Autowired
    private AutorRepository autorRepository;



}
