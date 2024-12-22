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
import com.alexis.proyecto.biblioteca_api.models.Autor;
import com.alexis.proyecto.biblioteca_api.services.impl.AutorServiceImpl;

/**
 * Controlador REST para gestionar las operaciones de autores.
 * Con endpoints par crear,leer,actualizar y borrar editoriales.
 * 
 * @author Alex
 */
@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorServiceImpl asi;

    /**
     * Obtiene una lista de todos los autores del sistema.
     * 
     * @return ResponseEntity con la lista de todos los autores y un estado HTTP 200. 
     */
    @GetMapping
    public ResponseEntity<List<Autor>> getAutores() {
        List<Autor> autores = asi.getAutores();
        return ResponseEntity.ok(autores);
    }

    /**
     * Obtiene el autor por su ID.
     * 
     * @param idAutor  ID del autor a buscar.
     * @return  ResponseEntity con el Autor y un estado HTTP 200.
     */
    @GetMapping("/{idAutor}")
    public ResponseEntity<?> getAutorById(@PathVariable int idAutor) {
        try {
            Autor autor = asi.getAutorById(idAutor);
            return ResponseEntity.ok(autor);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Autor no encontrado con el id:" + idAutor + "\n Error : " + e.getMessage());
        }
    }

    /**
     * Crea una instancia de Autor.
     * 
     * @param autor Objeto Autor enviado en la solicitud.
     * @return ResponseEntity con el Autor creado y un estado HTTP 200,
     * en caso contrario un error con estado HTTP 400.
     */
    @PostMapping()
    public ResponseEntity<?> postAutor(@RequestBody Autor autor) {
        try {
            asi.createAutor(autor);
            return ResponseEntity.ok(autor);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }


    /**
     * Actualiza a un Autor por su ID.
     * 
     * @param autor Objeto Autor enviado en la solicitud con los datos actualizados.
     * @param idAutor ID del Autor a actualizar.
     * @return ResponseEntity con un estado HTTP 204, en caso contrario,
     * un estado HTTP 404.
     */
    @PutMapping("/{idAutor}")
    public ResponseEntity<?> putAutor(@RequestBody Autor autor, @PathVariable int idAutor) {
        try {
            asi.putAutor(autor, idAutor);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Elimina un Autor por su ID.
     * 
     * @param idAutor ID del Autor a eliminar.
     * @return ResponseEntity con un estado HTTP 204, en caso contrario un
     * mensaje de error con un estado HTTP 404.
     */
    @DeleteMapping("/{idAutor}")
    public ResponseEntity<?> deleteAutor(@PathVariable int idAutor) {
        try {
            asi.deleteAutor(idAutor);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Autor no encontrado con el id:" + idAutor + "\n Error : " + e.getMessage());
        }
    }

}
