package com.alexis.proyecto.biblioteca_api.models;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase representa la entidad Libro
 * Administra los libros de la aplicacion.
 * 
 * @author Alex
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "libros")
public class Libro {

    /* ID unico del libro. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLibro;

    /* Genero del libro. */
    @Column(nullable = false)
    private String genero;

    /* Titulo del libro. */
    @Column(nullable = false)
    private String titulo;

    /* Entidad de Autor asociada. */
    @ManyToOne
    @JoinColumn(name = "id_autor", nullable = true)
    private Autor autor;

    /* Entidad de Editorial asociada. */
    @ManyToOne
    @JoinColumn(name = "id_editorial", nullable = true)
    private Editorial editorial;

    /* Fecha en que fue publicado el libro. */
    private LocalDate fechaPublicacion;

    /* Campo para saber si el registro esta activo. */
    private Boolean activo = true;

}
