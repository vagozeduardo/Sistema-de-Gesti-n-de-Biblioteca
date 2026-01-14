package com.example.SistemaBiblioteca.repository;

import com.example.SistemaBiblioteca.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro,Integer> {



}
