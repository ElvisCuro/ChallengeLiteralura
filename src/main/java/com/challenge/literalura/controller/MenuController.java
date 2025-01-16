package com.challenge.literalura.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;
@Controller
public class MenuController {
    private final LibroController libroController;

    private final AutorController autorController;

    @Autowired
    public MenuController(LibroController libroController, AutorController autorController) {
        // Constructor vacío para Spring
        this.libroController = libroController;
        this.autorController = autorController;
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1 - Buscar libro por título");
            System.out.println("2 - Listar libros registrados");
            System.out.println("3 - Listar autores registrados");
            System.out.println("4 - Listar autores vivos en un determinado año");
            System.out.println("5 - Listar libros por idioma");
            System.out.println("0 - Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> libroController.buscarLibroPorTitulo();
                case 3 -> autorController.listarAutores();
                case 0 -> System.out.println("Saliendo de la aplicación...");
                default -> System.out.println("Opción no válida, intente nuevamente.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
