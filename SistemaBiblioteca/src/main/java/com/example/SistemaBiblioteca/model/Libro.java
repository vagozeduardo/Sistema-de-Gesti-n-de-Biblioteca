package com.example.SistemaBiblioteca.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

@Entity
public class Libro {

    /*
     * Se la tabla desde Spring con los siguientes valores
     */
    // id marcado como @Id y dafinido como auto generado
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // titulo de tipo String y definido como campo no vacio(not null) en la base
    @Column(nullable = false)
    private String titulo;

    // autor de tipo String y definido como campo no vacio en la base
    @Column(nullable = false)
    private String autor;

    // ISBN de tipo String y definido como campo no vacio en la base y como una clave unica en la base
    @Column(nullable = false, unique = true)
    private String ISBN;

    /*
    año de tipo entero, por cuestiones practicas y definido asi, ya que el tipo year en mysql no permitia mas alla de 1000
    y si desea guardar una fecha como el del libro de la odisea que es 800 A.c.
    Ademas es un campo no vacio en la base
     */
    // Pensandolo bien, era fecha de edicion y no de cracion que se guarda normalmente
    @Column(nullable = false)
    private Integer anioPublicacion;

    // // genero de tipo String y definido como campo no vacio en la base
    @Column(nullable = false)
    private String genero;

    // cantidad disponible de tipo entero y definido como campo no vacio en la base
    @Column(nullable = false)
    private Integer cantidadDisponible;


}
