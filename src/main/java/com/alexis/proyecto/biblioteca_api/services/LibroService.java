package com.alexis.proyecto.biblioteca_api.services;

import java.util.List;

import com.alexis.proyecto.biblioteca_api.models.Libro;

/**
 * Interface de Servicio para la gestion de libros.
 * 
 * @author Alex
 */
public interface LibroService {

    /**
     * Obtiene una lista de {@link Libro}
     * 
     * @return una lista de {@link Libro}
     */
    List<Libro> getLibros();

    /**
     * Obtiene una instacia {@link Libro} atravez de su ID.
     * 
     * @param idLibro ID de {@link Libro}
     * @return Instancia de {@link Libro} buscada por ID.
     */
    Libro getLibroById(Integer idLibro);

    /**
     * Crea una instancia de {@link Libro}
     * 
     * @param libro instancia a crear.
     * @return instancia creada.
     */
    Libro createLibro(Libro libro);

    /**
     * Actualiza una instancia creada de {@link Libro}
     * 
     * @param idLibro ID del {@link Libro} a actualizar.
     * @param libro   Instancia de {@link Libro} a actualizar.
     * 
     * @return La instancia de {@link Libro} actualizada
     */
    Libro putLibro(Libro libro, Integer idLibro);

    /**
     * Borra una instancia de {@link Libro}
     * 
     * @param Idlibro ID del {@link Libro} a borrar.
     */
    void deleteLibro(Integer IdLibro);

}
