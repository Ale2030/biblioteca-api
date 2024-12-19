package com.alexis.proyecto.biblioteca_api.services;

import java.util.List;

import com.alexis.proyecto.biblioteca_api.models.Editorial;

/**
 * Interface de Servicio para la gestion de editoriales.
 * @author Alex
 */
public interface EditorialService {

    /**
     * Obtiene una lista de {@link Editorial}
     * 
     * @return lista de {@link Editorial}
     */
    List<Editorial> getEditoriales();

    /**
     * Obtiene una editorial buscando por ID
     * 
     * @param idEditorial ID de la {@link Editorial} a buscar.
     * @return la {@link Editorial} buscada por ID.
     */
    Editorial getEditorialById(Integer idEditorial);

    /**
     * Crea una instancia de {@link Editorial}
     * 
     * @param editorial Instancia de {@link Editorial} a crear.
     * @return La instancia {@link Editorial} creada.
     */
    Editorial createEditorial(Editorial editorial);

    /**
     * Actualiza una instancia de {@link Editorial} ya creada.
     * 
     * @param editorial   Instancia a actualizar.
     * @param idEditorial ID de la editorial a actualizar.
     * @return {@link Editorial} actualizada.
     */
    Editorial putEditorial(Editorial editorial, Integer idEditorial);

    /**
     * Borra una editorial existente.
     * 
     * @param idEditorial ID de {@link Editorial} a borrar.
     */
    void deleteEditorial(Integer idEditorial);

}
