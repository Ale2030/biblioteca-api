package com.alexis.proyecto.biblioteca_api.models;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa la entidad Editorial
 * Administra las editoriales y sus libros asociados
 * 
 * @author Alex
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "editoriales")
public class Editorial {

    /* ID unico de la Editorial. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /* Nombre Editorial. */
    @Column(nullable = false)
    private String nombreEditorial;

    /* Direccion de Oficina Editorial. */
    @Column(nullable = false)
    private String oficinaEditorial;

    /* Lista de libros asociados. */
    @OneToMany(mappedBy = "editorial", cascade = CascadeType.ALL)
    private List<Libro> libros;

      /* Campo Editorial esta activa. */
      private Boolean activo = true;

}
