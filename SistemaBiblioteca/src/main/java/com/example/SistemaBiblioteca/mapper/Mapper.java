package com.example.SistemaBiblioteca.mapper;

import com.example.SistemaBiblioteca.dto.LibroDTO;
import com.example.SistemaBiblioteca.dto.LibroUpdateDTO;
import com.example.SistemaBiblioteca.model.Libro;

public class Mapper {

    // Mapeo de Libro a LibroDTO
    // se mapea el entity/model al DTO que se usara para manipular los datos
    public static LibroDTO toDTO(Libro l){

        // verifica que sea un dato existente o se envia un null para evitar errores
        if (l == null)
            return null;

        // se mapea el DTO relacionando cada campo con el campo del model
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

    // Mapeo de Libro a LibroUpdateDTO
    // se mapea el entity/model al DTO que se usara para manipular los datos
    public static LibroUpdateDTO toUpdateDTO(Libro l){

        // verifica que sea un dato existente o se envia un null para evitar errores
        if (l == null)
            return null;

        // se mapea el DTO relacionando cada campo con el campo del model
        return LibroUpdateDTO.builder()
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
