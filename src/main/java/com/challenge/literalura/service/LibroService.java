package com.challenge.literalura.service;


import com.challenge.literalura.model.Libro;
import com.challenge.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    // Guardar un libro en la base de datos
    public Libro guardarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    // Listar todos los libros registrados
    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

//    // Buscar libros por título (con texto parcial)
//    public List<Libro> buscarLibrosPorTitulo(String titulo) {
//        return libroRepository.findByTituloContainingIgnoreCase(titulo);
//    }

    // Listar libros por idioma
    public List<Libro> listarLibrosPorIdioma(String idioma) {
        return libroRepository.findByIdioma(idioma);
    }
}