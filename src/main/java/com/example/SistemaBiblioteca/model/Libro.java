package com.example.SistemaBiblioteca.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String titulo;


    @Column(nullable = false)
    private String autor;

    @Column(nullable = false, unique = true)
    private String ISBN;

    @Column(nullable = false)
    private Integer anioPublicacion;

    @Column(nullable = false)
    private String genero;

    @Column(nullable = false)
    private Integer cantidadDisponible;


}
