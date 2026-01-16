package com.example.SistemaBiblioteca.repository;

import com.example.SistemaBiblioteca.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro,Integer> {

    // Busqueda (query) personalizada ya sea con titulo o autor

    /*
    * se modifco para que no busque la conincidencia exacta, mas bien si contiene esos valores con el "Containing":
    * codigo anterior: "findByTituloIgnoreCaseOrAutorIgnoreCase"
    *
     */
    List<Libro> findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCase(String titulo, String autor);

    // se definio un consulta para buscar por el ISBN para una validadcion
    boolean existsByISBN(String ISBN);
    //Optional<Libro> findByIsbn(String isbn);

}
