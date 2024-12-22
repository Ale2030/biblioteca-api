package com.alexis.proyecto.biblioteca_api.services.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alexis.proyecto.biblioteca_api.models.Editorial;
import com.alexis.proyecto.biblioteca_api.repositories.EditorialRepository;
import com.alexis.proyecto.biblioteca_api.services.EditorialService;

/**
 * Servicio que implementa la logica de negocio relacionada con la entidad
 * {@link Editorial}.
 * Esta clase utiliza e implementa {@link EditorialService}.
 * 
 * @author Alex
 */

@Service
public class EditorialServiceImpl implements EditorialService {

    @Autowired
    private EditorialRepository er;

    @Override
    public Editorial createEditorial(Editorial editorial) {
        Editorial editorialCreada = er.save(editorial);
        return editorialCreada;
    }

    @Override
    public void deleteEditorial(Integer idEditorial) {
        Editorial editorial = er.findById(idEditorial).get();

        editorial.setActivo(false);
        er.save(editorial);
    }

    @Override
    public Editorial getEditorialById(Integer idEditorial) {
        Editorial editorial = er.findById(idEditorial).get();
        if (!editorial.getActivo()) {
            throw new IllegalArgumentException("La editorial no se encontro.");
        }
        return editorial;
    }

    @Override
    public List<Editorial> getEditoriales() {
        List<Editorial> editoriales = (List<Editorial>) er.findAll();

        List<Editorial> editorialesActivos = editoriales.stream()
                .filter(editorial -> editorial.getActivo())
                .collect(Collectors.toList());

        return editorialesActivos;
    }

    @Override
    public Editorial putEditorial(Editorial editorial, Integer idEditorial) {
        Editorial editorialExistente = er.findById(idEditorial).get();

        editorialExistente.setNombreEditorial(editorial.getNombreEditorial());
        editorialExistente.setOficinaEditorial(editorial.getOficinaEditorial());
        editorialExistente.setLibros(editorial.getLibros());

        er.save(editorialExistente);
        return editorialExistente;
    }

}
