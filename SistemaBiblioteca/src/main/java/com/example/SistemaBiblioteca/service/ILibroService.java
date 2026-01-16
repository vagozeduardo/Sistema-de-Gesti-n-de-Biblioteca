package com.example.SistemaBiblioteca.service;

import com.example.SistemaBiblioteca.dto.LibroDTO;
import com.example.SistemaBiblioteca.dto.LibroUpdateDTO;
import com.example.SistemaBiblioteca.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface ILibroService {

    // metodos definidos de forma abstracta para ser usados
    List<LibroDTO> traerDatos();
    Optional<LibroDTO> traerPorId(Integer id);
    LibroDTO crear(LibroDTO libroDTO);
    LibroUpdateDTO actualizarLibro(Integer id, LibroUpdateDTO libroUpdateDTODTO);
    void  eliminar (Integer id);
    List<LibroDTO> busquedaPorTermino(String termino);


}
