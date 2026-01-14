package com.example.SistemaBiblioteca.service;

import com.example.SistemaBiblioteca.dto.LibroDTO;

import java.util.List;
import java.util.Optional;

public interface ILibroService {

    List<LibroDTO> traerDatos();
    Optional<LibroDTO> traerPorId();
    LibroDTO crear(LibroDTO libroDTO);
    LibroDTO actualizarLibro(Integer id, LibroDTO libroDTO);
    void  eliminar (Integer id);
    List<LibroDTO> busquedaPorTermino(String termino);


}
