package com.challenge.literalura.controller;

import com.challenge.literalura.api.ConvertirDatos;
import com.challenge.literalura.api.GutendexApiService;
import com.challenge.literalura.model.Libro;
import com.challenge.literalura.model.LibrosRespuestaApi;
import com.challenge.literalura.model.records.DatosLibro;
import com.challenge.literalura.repository.AutorRepository;
import com.challenge.literalura.repository.LibroRepository;
import com.challenge.literalura.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;


@Controller
public class LibroController {
    private final ConvertirDatos convertir = new ConvertirDatos();
    private final Scanner teclado = new Scanner(System.in);
    private static final String API_BASE = "https://gutendex.com/books/?search=";

    @Autowired
    private LibroService libroService;

    @Autowired
    private GutendexApiService gutendexApiService;

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    public LibroController() {
        // Constructor vacío para Spring
    }

    private Libro getDatosLibro() {
        System.out.println("Ingrese el nombre del libro: ");
        var nombreLibro = teclado.nextLine().toLowerCase();
        var json = gutendexApiService.obtenerDatos(API_BASE + nombreLibro.replace(" ", "%20"));
        var datos = convertir.obtenerDatos(json, LibrosRespuestaApi.class);

        if (datos != null && !datos.getResultadoLibros().isEmpty()) {
            DatosLibro primerLibro = datos.getResultadoLibros().get(0);
            return new Libro(primerLibro);
        } else {
            System.out.println("No se encontraron resultados.");
            return null;
        }
    }

    public void buscarLibroPorTitulo() {
        Libro libro = getDatosLibro();

        if (libro == null) {
            System.out.println("Libro no encontrado. El valor es null");
            return;
        }

        try {
            boolean libroExists = libroRepository.existsByTitulo(libro.getTitulo());
            if (libroExists) {
                System.out.println("El libro ya existe en la base de datos!");
            } else {
                libroRepository.save(libro);
                System.out.println(libro.toString());
            }
        } catch (InvalidDataAccessApiUsageException e) {
            System.out.println("No se puede persistir el libro buscado!");
            e.printStackTrace();
        }
    }
}
//    // Listar todos los libros registrados en la base de datos
//    public void listarLibros() {
//        List<Libro> libros = libroService.listarLibros();
//        if (libros.isEmpty()) {
//            System.out.println("No hay libros registrados.");
//        } else {
//            libros.forEach(libro -> System.out.println(
//                    "ID: " + libro.getId() + ", Título: " + libro.getTitulo() + ", Idioma: " + libro.getIdioma()
//            ));
//        }
//    }
//
//    // Listar libros por idioma
//    public void listarLibrosPorIdioma(Scanner scanner) {
//        System.out.print("Ingrese el idioma que desea buscar: ");
//        String idioma = scanner.next();
//        List<Libro> libros = libroService.listarLibrosPorIdioma(idioma);
//
//        if (libros.isEmpty()) {
//            System.out.println("No se encontraron libros en el idioma especificado.");
//        } else {
//            libros.forEach(libro -> System.out.println(
//                    "ID: " + libro.getId() + ", Título: " + libro.getTitulo()
//            ));
//        }
//    }
//}