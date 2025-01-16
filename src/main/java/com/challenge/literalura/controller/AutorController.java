package com.challenge.literalura.controller;

import com.challenge.literalura.model.Autor;
import com.challenge.literalura.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AutorController {

    @Autowired
    private AutorService autorService;

    // Listar todos los autores registrados
    public void listarAutores() {
        List<Autor> autores = autorService.listarAutores();
        if (autores.isEmpty()) {
            System.out.println("No hay autores registrados.");
        } else {
            autores.forEach(autor -> System.out.println(
                    "ID: " + autor.getId() + ", Nombre: " + autor.getNombre()
            ));
        }
    }

//    // Listar autores vivos en un año determinado
//    public void listarAutoresVivosPorAnio(Scanner scanner) {
//        System.out.print("Ingrese el año (YYYY): ");
//        int anio = scanner.nextInt();
//        List<Autor> autores = autorService.listarAutoresVivosAPartirDe(LocalDate.of(anio, 1, 1));
//
//        if (autores.isEmpty()) {
//            System.out.println("No se encontraron autores vivos en el año indicado.");
//        } else {
//            autores.forEach(autor -> System.out.println(
//                    "ID: " + autor.getId() + ", Nombre: " + autor.getNombre()
//            ));
//        }
//    }
}