package com.example.SistemaBiblioteca.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder

@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;

    private String autor;

    @Column(nullable = false, unique = true)
    private String ISBN;

    private LocalDate anioPublicacion;

    private String genero;

    private Integer cantidadDisponible;


}
