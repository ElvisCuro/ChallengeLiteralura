package com.challenge.literalura.service;


import com.challenge.literalura.model.Autor;
import com.challenge.literalura.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    // Guardar un autor en la base de datos
    public Autor guardarAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    // Listar todos los autores registrados
    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

//    // Listar autores vivos a partir de un año
//    public List<Autor> listarAutoresVivosAPartirDe(LocalDate anio) {
//        return autorRepository.findByFechaNacimientoGreaterThanEqualAndFechaFallecimientoIsNull(anio);
//    }
}