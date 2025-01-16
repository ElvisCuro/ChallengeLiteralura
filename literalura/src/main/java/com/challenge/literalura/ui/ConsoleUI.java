package com.challenge.literalura.ui;

import com.challenge.literalura.service.LibraryService;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class ConsoleUI {
    private final LibraryService libraryService;
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        boolean running = true;
        while (running) {
            displayMenu();
            try {
                int option = Integer.parseInt(scanner.nextLine());
                running = handleOption(option);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n=== BIBLIOTECA DIGITAL ===");
        System.out.println("1. Agregar libro por nombre");
        System.out.println("2. Ver libros más descargados");
        System.out.println("3. Buscar autor");
        System.out.println("4. Buscar autores por año");
        System.out.println("0. Salir");
        System.out.print("\nSeleccione una opción: ");
    }

    private boolean handleOption(int option) {
        switch (option) {
            case 1 -> addBook();
            case 2 -> showTopBooks();
            case 3 -> searchAuthor();
            case 4 -> findAuthorsInYear();
            case 0 -> {
                System.out.println("¡Hasta luego!");
                return false;
            }
            default -> System.out.println("Opción no válida");
        }
        return true;
    }

    private void addBook() {
        System.out.print("Ingrese el nombre del libro: ");
        String bookName = scanner.nextLine();
        try {
            libraryService.addBookByName(bookName);
            System.out.println("Libro agregado exitosamente");
        } catch (Exception e) {
            System.out.println("Error al agregar el libro: " + e.getMessage());
        }
    }

    private void showTopBooks() {
        System.out.println("\n=== Libros Más Descargados ===");
        try {
            var topBooks = libraryService.getTopDownloadedBooks();
            topBooks.forEach(book -> System.out.println("- " + book));
        } catch (Exception e) {
            System.out.println("Error al obtener los libros más descargados: " + e.getMessage());
        }
    }

    private void searchAuthor() {
        System.out.print("Ingrese el nombre del autor: ");
        String authorName = scanner.nextLine();
        try {
            var booksByAuthor = libraryService.getBooksByAuthor(authorName);
            if (booksByAuthor.isEmpty()) {
                System.out.println("No se encontraron libros para este autor.");
            } else {
                System.out.println("\n=== Libros de " + authorName + " ===");
                booksByAuthor.forEach(book -> System.out.println("- " + book));
            }
        } catch (Exception e) {
            System.out.println("Error al buscar libros por autor: " + e.getMessage());
        }
    }

    private void findAuthorsInYear() {
        System.out.print("Ingrese el año: ");
        try {
            int year = Integer.parseInt(scanner.nextLine());
            var authors = libraryService.getAuthorsByYear(year);
            if (authors.isEmpty()) {
                System.out.println("No se encontraron autores para el año " + year + ".");
            } else {
                System.out.println("\n=== Autores en el año " + year + " ===");
                authors.forEach(author -> System.out.println("- " + author));
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese un año válido.");
        } catch (Exception e) {
            System.out.println("Error al buscar autores por año: " + e.getMessage());
        }
    }
}
