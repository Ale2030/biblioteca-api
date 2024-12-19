package com.alexis.proyecto.biblioteca_api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alexis.proyecto.biblioteca_api.models.Editorial;

/**
 * Interface que implementa {@link CrudRepository}
 * Administra al {@link Editorial}
 */
@Repository
public interface EditorialRepository extends CrudRepository<Editorial, Integer> {

}
