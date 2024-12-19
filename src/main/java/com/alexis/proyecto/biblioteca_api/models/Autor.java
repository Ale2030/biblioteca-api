package com.alexis.proyecto.biblioteca_api.models;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase representa la entidad Autor
 * Administra a los autores
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "autores")
public class Autor {

    /* ID unico del Autor */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /* Nombre completo del Autor. */
    @Column(nullable = false, length = 100)
    private String nombre;

    /* Fecha nacimiento del Autor. */
    private LocalDate fechaNacimiento;

    /* Nacionalidad del Autor. */
    private String nacionalidad;

    /* Biografia del autor. */
    private String biografia;

     /* Campo Autor esta activo.*/
     private Boolean activo = true;

}
