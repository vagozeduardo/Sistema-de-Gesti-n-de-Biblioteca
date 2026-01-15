package com.example.SistemaBiblioteca.service;

import com.example.SistemaBiblioteca.dto.LibroDTO;
import com.example.SistemaBiblioteca.exception.NotFoundException;
import com.example.SistemaBiblioteca.mapper.Mapper;
import com.example.SistemaBiblioteca.model.Libro;
import com.example.SistemaBiblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService implements ILibroService {


    @Autowired
    LibroRepository repo;

    @Override
    public List<LibroDTO> traerDatos() {
        return repo.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public Optional<LibroDTO> traerPorId(Integer id) {
        Optional<Libro> libroEsta = repo.findById(id);
        if (!libroEsta.isPresent())
            throw new NotFoundException("El libro con el id: " + id + " no existe");
        return repo.findById(id).map(Mapper::toDTO);
    }

    @Override
    public LibroDTO crear(LibroDTO libroDTO) {


        var libro = Libro.builder()
                .titulo(libroDTO.getTitulo())
                .autor(libroDTO.getAutor())
                .ISBN(libroDTO.getISBN())
                .anioPublicacion(libroDTO.getAnioPublicacion())
                .genero(libroDTO.getGenero())
                .cantidadDisponible(libroDTO.getCantidadDisponible())
                .build();
        return Mapper.toDTO(repo.save(libro));
    }

    @Override
    public LibroDTO actualizarLibro(Integer id, LibroDTO libroDTO) {

        // existe el producto
        Libro libro = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("No se puede actualizar. El libro con ID: " + id + ", no existe."));

        if (libroDTO.getTitulo() != null) libro.setTitulo(libroDTO.getTitulo());
        if (libroDTO.getAutor() != null) libro.setAutor(libroDTO.getAutor());
        if (libroDTO.getISBN() != null) libro.setISBN(libroDTO.getISBN());
        if (libroDTO.getAnioPublicacion() != null) libro.setAnioPublicacion(libroDTO.getAnioPublicacion());
        if (libroDTO.getGenero() != null) libro.setGenero(libroDTO.getGenero());
        if (libroDTO.getCantidadDisponible() != null) libro.setCantidadDisponible(libroDTO.getCantidadDisponible());

        return Mapper.toDTO(repo.save(libro));
    }

    @Override
    public void eliminar(Integer id) {
        if (!repo.existsById(id))
            throw new RuntimeException("Dato no encontrado");

        repo.deleteById(id);

    }

    @Override
    public List<LibroDTO> busquedaPorTermino(String termino) {
        return repo.findByTituloIgnoreCaseOrAutorIgnoreCase(termino, termino)
                .stream()
                .map(Mapper::toDTO)
                .toList();
    }
}
