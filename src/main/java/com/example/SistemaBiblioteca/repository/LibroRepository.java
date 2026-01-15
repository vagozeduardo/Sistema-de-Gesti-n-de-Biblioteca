package com.example.SistemaBiblioteca.repository;

import com.example.SistemaBiblioteca.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro,Integer> {

    // Busqueda (query) personalizada ya sea con titulo o autor
    List<Libro> findByTituloIgnoreCaseOrAutorIgnoreCase(String titulo, String autor);



}
