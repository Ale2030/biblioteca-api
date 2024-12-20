package com.alexis.proyecto.biblioteca_api.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexis.proyecto.biblioteca_api.models.Autor;
import com.alexis.proyecto.biblioteca_api.repositories.AutorRepository;
import com.alexis.proyecto.biblioteca_api.services.AutorService;

/**
 * Servicio que implementa la logica de negocio relacionada con la entidad
 * {@link Autor}.
 * Esta clase utiliza e implementa {@link AutorService}.
 *
 * @author Alex
 */
@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    private AutorRepository ar;

    @Override
    public List<Autor> getAutores() {
        List<Autor> autores = (List<Autor>) ar.findAll();
        List<Autor> autoresActivos = autores.stream()
                .filter(libro -> libro.getActivo())
                .collect(Collectors.toList());
        return autoresActivos;
    }

    @Override
    public Autor getAutorById(Integer idAutor) {
        Autor autor = ar.findById(idAutor).get();
        return autor;
    }

    @Override
    public Autor createAutor(Autor autor) {
        Autor autorCreado = ar.save(autor);
        return autorCreado;
    }

    @Override
    public Autor putAutor(Autor autor, Integer idAutor) {
        Autor autorExistente = ar.findById(idAutor).get();

        autorExistente.setNombre(autor.getNombre());
        autorExistente.setFechaNacimiento(autor.getFechaNacimiento());
        autorExistente.setNacionalidad(autor.getNacionalidad());
        autorExistente.setBiografia(autor.getBiografia());

        ar.save(autorExistente);

        return autorExistente;
    }

    @Override
    public void deleteAutor(Integer idAutor) {
        Autor autor = ar.findById(idAutor).get();

        autor.setActivo(false);
        ar.save(autor);
    }

}
