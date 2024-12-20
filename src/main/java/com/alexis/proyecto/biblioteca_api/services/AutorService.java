package com.alexis.proyecto.biblioteca_api.services;

import java.util.List;

import com.alexis.proyecto.biblioteca_api.models.Autor;

/**
 * Interface de Servicio para la gestion de autores.
 * 
 * @author Alex
 */
public interface AutorService {

    /**
     * Obtiene una lista de autores.
     * 
     * @return Una lista de autores.
     */
    List<Autor> getAutores();

    /**
     * Obtiene un {@link Autor} por ID
     * 
     * @param idAutor ID del {@link Autor} a buscar.
     * @return Un {@link Autor} buscado por ID.
     */
    Autor getAutorById(Integer idAutor);

    /**
     * Crea una instancia de un {@link Autor}.
     * 
     * @param autor Instancia de {@link Autor} a crear.
     * @return La instancia creada de {@link Autor}.
     */
    Autor createAutor(Autor autor);

    /**
     * Actualiza una instancia de {@link Autor} existente.
     * 
     * @param autor   Instancia de {@link Autor} a actualizar.
     * @param idAutor ID del {@link Autor} a buscar.
     * @return
     */
    Autor putAutor(Autor autor, Integer idAutor);

    /**
     * Borra un {@Autor}
     * 
     * @param idAutor id del {@link Autor}
     */
    void deleteAutor(Integer idAutor);

}