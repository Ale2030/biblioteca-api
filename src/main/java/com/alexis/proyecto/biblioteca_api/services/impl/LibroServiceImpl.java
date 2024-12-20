package com.alexis.proyecto.biblioteca_api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexis.proyecto.biblioteca_api.models.Libro;
import com.alexis.proyecto.biblioteca_api.repositories.LibroRepository;
import com.alexis.proyecto.biblioteca_api.services.LibroService;

/**
 * Servicio que implementa la logica de negocio relacionada con la entidad
 * {@link Libro}.
 * Esta clase utiliza e implementa {@link LibroService}.
 * 
 * @author Alex
 */
@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private LibroRepository lr;

    @Override
    public List<Libro> getLibros() {
        List<Libro> libros = (List<Libro>) lr.findAll();
        return libros;
    }

    @Override
    public Libro getLibroById(Integer idLibro) {
        Libro libro = lr.findById(idLibro).get();
        return libro;
    }

    @Override
    public Libro createLibro(Libro libro) {
        Libro libroCreado = lr.save(libro);
        return libroCreado;

    }

    @Override
    public Libro putLibro(Libro libro, Integer idLibro) {
        Libro libroExistente = lr.findById(idLibro).get();

        libroExistente.setGenero(libro.getGenero());
        libroExistente.setTitulo(libro.getTitulo());
        libroExistente.setAutor(libro.getAutor());
        libroExistente.setEditorial(libro.getEditorial());
        libroExistente.setFechaPublicacion(libro.getFechaPublicacion());

        lr.save(libroExistente);

        return libroExistente;

    }

    @Override
    public void deleteLibro(Integer idLibro) {
        Libro libro = lr.findById(idLibro).get();

        libro.setActivo(false);
        lr.save(libro);
    }

}
