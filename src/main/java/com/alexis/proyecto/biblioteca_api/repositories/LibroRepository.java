package com.alexis.proyecto.biblioteca_api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alexis.proyecto.biblioteca_api.models.Libro;

/**
 * Interface que implementa {@link CrudRepository}
 * Administra al {@link Libro}
 */
@Repository
public interface LibroRepository extends CrudRepository<Libro,Integer> {

}
