package com.example.SistemaBiblioteca.dto;


import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LibroDTO {

    private Integer id;
    private String titulo;
    private String autor;
    private String ISBN;
    private LocalDate anioPublicacion;
    private String genero;
    private Integer cantidadDisponible;

}
