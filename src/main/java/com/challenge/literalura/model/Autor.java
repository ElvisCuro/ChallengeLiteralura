package com.challenge.literalura.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "fecha_fallecimiento")
    private LocalDate fechaFallecimiento;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        try {
            this.fechaNacimiento = LocalDate.parse(fechaNacimiento);
        } catch (DateTimeParseException e) {
            this.fechaNacimiento = null;
        }
    }

    public LocalDate getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(String fechaFallecimiento) {
        try {
            this.fechaFallecimiento = LocalDate.parse(fechaFallecimiento);
        } catch (DateTimeParseException e) {
            this.fechaFallecimiento = null;
        }
    }
}