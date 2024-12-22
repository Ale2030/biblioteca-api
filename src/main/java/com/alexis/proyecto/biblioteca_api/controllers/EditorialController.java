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
import com.alexis.proyecto.biblioteca_api.models.Editorial;
import com.alexis.proyecto.biblioteca_api.services.impl.EditorialServiceImpl;
/**
 * Controllador REST para gestionar las operaciones de editoriales.
 * Con endpoints par crear,leer,actualizar y borrar editoriales.
 * 
 * @author Alex
 */
@RestController
@RequestMapping("/editoriales")
public class EditorialController {

    @Autowired
    private EditorialServiceImpl esi;

    /**
     * Obtiene todas las editoriales del sistema.
     * 
     * @return ResponseEntity con la lista de todas las editoriales y un estado HTTP 200.
     */
    @GetMapping
    public ResponseEntity<List<Editorial>> getEditoriales() {
        List<Editorial> editoriales = esi.getEditoriales();

        return ResponseEntity.ok(editoriales);
    }

    /**
     * Obtiene una editorial por su idEditorial.
     * 
     * @param idEditorial id del editorial a buscar.
     * @return ResponseEntity con la editorial encotrada y un estado HTTP 200,
     * caso contrario error con estado HTTP 404.
     */
    @GetMapping("/{idEditorial}")
    public ResponseEntity<?> getEditorialById(@PathVariable int idEditorial) {

        try {
            Editorial editorial = esi.getEditorialById(idEditorial);
            return ResponseEntity.ok(editorial);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Editorial con el id: " + idEditorial + "no fue encontrada"
                            + "\n Error: " + e.getMessage());
        }
    }

    /**
     * Crea una editorial.
     * 
     * @param editorial Objeto Editorial enviado al cuerpo de la solicitud.
     * @return  ResponseEntity con la editorial creada y un estado HTTP 200,
     * en caso contrario error con estado HTTP 400.
     */
    @PostMapping
    public ResponseEntity<?> postEditorial(@RequestBody Editorial editorial) {
        try {
            esi.createEditorial(editorial);
            return ResponseEntity.ok(editorial);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    /**
     * Actualiza una editorial por su Id.
     * 
     * @param editorial Objeto Editorial enviado con los datos actualizados.
     * @param idEditorial ID de la Editorial para actualizar.
     * @return ResponseEntity con un estado HTTP 204, en caso contrario
     * un estado HTTP 404 si no encuentra la editorial.
     */
    @PutMapping("/{idEditorial}")
    public ResponseEntity<?> putEditorial(@RequestBody Editorial editorial, @PathVariable int idEditorial) {
        try {
            esi.putEditorial(editorial, idEditorial);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    /**
     * Elimina la Editorial por su id.
     * 
     * @param idEditorial ID de la Editorial a borrar.
     * @return ResponseEntity con un estado HTTP 204,
     * en caso contrario un mensaje de error con estado HTTP 404.
     */
    @DeleteMapping("/{idEditorial}")
    public ResponseEntity<?> deleteEditorial(@PathVariable int idEditorial) {
        try {
            esi.deleteEditorial(idEditorial);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Editorial con el id: " + idEditorial + " no fue encontrada"
                            + "\n Error: " + e.getMessage());
        }
    }

}
