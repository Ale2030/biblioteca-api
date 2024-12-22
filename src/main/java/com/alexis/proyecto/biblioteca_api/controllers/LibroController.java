package com.alexis.proyecto.biblioteca_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alexis.proyecto.biblioteca_api.models.Libro;
import com.alexis.proyecto.biblioteca_api.services.impl.LibroServiceImpl;

/**
 * Controllador REST para gestionar las operaciones de libros.
 * Con endpoints par crear,leer,actualizar y borrar editoriales.
 * 
 * @author Alex
 */
@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroServiceImpl lsi;

    /**
     * Obtiene una lista de los libros en el sistema.
     * 
     * @return ResponseEntity con una lista de todos los libros y un estado HTTP
     *         200.
     */
    @GetMapping
    public ResponseEntity<List<Libro>> getEditoriales() {

        List<Libro> libros = lsi.getLibros();
        return ResponseEntity.ok(libros);
    }

    /**
     * Obtiene un libro por su ID.
     * 
     * @param idLibro ID del libro a buscar.
     * @return ResponseEntity con el libro y un estado HTTP 200,
     *         caso contrario un error con estado HTTP 404.
     */
    @GetMapping("/{idLibro}")
    public ResponseEntity<?> getEditorialById(@PathVariable int idLibro) {
        try {
            Libro libro = lsi.getLibroById(idLibro);
            return ResponseEntity.ok(libro);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Libro con el id: " + idLibro + " no fue encontrado"
                            + "\n Error: " + e.getMessage());
        }
    }

    /**
     * Crea un nuevo libro.
     * 
     * @param libro Objeto Libro enviado en la solicitud.
     * @return ResponseEntity con el libro creado y un estado HTTP 200,
     *         caso contrario un error con estado HTTP 400.
     */
    @PostMapping
    public ResponseEntity<?> postLibro(@RequestBody Libro libro) {
        try {
            lsi.createLibro(libro);
            return ResponseEntity.ok(libro);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    /**
     * Actualiza el Libro por ID.
     * 
     * @param libro   Objero Libro enviado en la solicitud con datos actualizados.
     * @param idLibro ID del libro a actualizar.
     * @return ResponseEntity con un estado HTTP 204, en caso contrario
     *         un error con estado HTTP 404.
     */
    @PutMapping("/{idLibro}")
    public ResponseEntity<?> putLibro(@RequestBody Libro libro, @PathVariable int idLibro) {
        try {
            lsi.putLibro(libro, idLibro);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Elimina un Libro por su ID
     * 
     * @param idLibro ID del Libro a eliminar.
     * @return ResponseEntity con un estado HTTP 204,
     *         en caso contrario error con estado HTTP 404.
     */
    @DeleteMapping("/{idLibro}")
    public ResponseEntity<?> deleteLibro(@PathVariable int idLibro) {
        try {
            lsi.deleteLibro(idLibro);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

}
