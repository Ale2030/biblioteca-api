package com.alexis.proyecto.biblioteca_api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alexis.proyecto.biblioteca_api.models.Autor;

/**
 * Interface que extiende de {@link CrudRepository}
 * Administra al {@link Autor}
 */
@Repository
public interface AutorRepository extends CrudRepository<Autor, Integer> {

}
