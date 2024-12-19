package com.alexis.proyecto.biblioteca_api.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexis.proyecto.biblioteca_api.models.Autor;
import com.alexis.proyecto.biblioteca_api.repositories.AutorRepository;
import com.alexis.proyecto.biblioteca_api.services.AutorService;

@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    private AutorRepository ar;

    @Override
    public List<Autor> getAutores() {
        List<Autor> libros = (List<Autor>) ar.findAll();
        List<Autor> librosActivos = libros.stream()
                .filter(libro -> libro.getActivo())
                .collect(Collectors.toList());
        return librosActivos;
    }

    @Override
    public Autor geAutorById(Integer idAutor) {
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
        return autorExistente;
    }

    @Override
    public void deleteAutor(Integer idAutor) {
        Autor autor = ar.findById(idAutor).get();

        autor.setActivo(false);
        ar.save(autor);
        throw new UnsupportedOperationException("Unimplemented method 'deleteAutor'");
    }

}
