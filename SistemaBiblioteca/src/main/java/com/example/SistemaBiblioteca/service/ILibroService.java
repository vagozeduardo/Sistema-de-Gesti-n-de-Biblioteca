package com.example.SistemaBiblioteca.service;

import com.example.SistemaBiblioteca.dto.LibroDTO;
import com.example.SistemaBiblioteca.dto.LibroUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ILibroService {

    // metodos definidos de forma abstracta para ser usados
    Page<LibroDTO> traerDatos(Pageable pageable);
    Optional<LibroDTO> traerPorId(Integer id);
    LibroDTO crear(LibroDTO libroDTO);
    LibroUpdateDTO actualizarLibro(Integer id, LibroUpdateDTO libroUpdateDTODTO);
    void  eliminar (Integer id);
    Page<LibroDTO> busquedaPorTermino(String termino,Pageable pageable);


}
