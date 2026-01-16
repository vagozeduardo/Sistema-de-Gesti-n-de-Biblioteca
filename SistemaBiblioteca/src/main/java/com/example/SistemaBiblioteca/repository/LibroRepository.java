package com.example.SistemaBiblioteca.repository;

import com.example.SistemaBiblioteca.model.Libro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro,Integer> {

    // Busqueda (query) personalizada ya sea con titulo o autor

    /*
    * se modifco para que no busque la conincidencia exacta, mas bien si contiene esos valores con el "Containing":
    * codigo anterior: "findByTituloIgnoreCaseOrAutorIgnoreCase"
    *
     */
    @Query("SELECT l FROM Libro l WHERE " +
            "(:termino IS NULL OR :termino = '' OR " +
            "LOWER(l.titulo) LIKE LOWER(CONCAT('%', :termino, '%')) OR " +
            "LOWER(l.autor) LIKE LOWER(CONCAT('%', :termino, '%')))")
    Page<Libro> findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCase(@Param("termino")String termino, Pageable pageable);

    // se definio un consulta para buscar por el ISBN para una validadcion
    boolean existsByISBN(String ISBN);
    //Optional<Libro> findByIsbn(String isbn);

}
