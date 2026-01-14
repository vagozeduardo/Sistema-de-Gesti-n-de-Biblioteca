package com.example.SistemaBiblioteca.mapper;

import com.example.SistemaBiblioteca.dto.LibroDTO;
import com.example.SistemaBiblioteca.model.Libro;

public class Mapper {

    // Mapeo de Libro a LibroDTO
    public static LibroDTO toDTO(Libro l){
        if (l == null)
            return null;

        return LibroDTO.builder()
                .id(l.getId())
                .titulo(l.getTitulo())
                .autor(l.getAutor())
                .ISBN(l.getISBN())
                .anioPublicacion(l.getAnioPublicacion())
                .genero(l.getGenero())
                .cantidadDisponible(l.getCantidadDisponible())
                .build();

    }

}
