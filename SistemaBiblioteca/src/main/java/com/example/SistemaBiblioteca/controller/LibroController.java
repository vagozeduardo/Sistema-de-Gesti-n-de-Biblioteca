package com.example.SistemaBiblioteca.controller;


import com.example.SistemaBiblioteca.dto.LibroDTO;
import com.example.SistemaBiblioteca.exception.NotFoundException;
import com.example.SistemaBiblioteca.service.ILibroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/api/books")
public class LibroController {

    @Autowired
    ILibroService iLibroService;

    @GetMapping
    public ResponseEntity<List<LibroDTO>> obtenerLibros(){
        return ResponseEntity.ok(iLibroService.traerDatos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<LibroDTO>> obtenerPorId(@PathVariable Integer id) {
        Optional<LibroDTO> libro = iLibroService.traerPorId(id);
        return ResponseEntity.ok(libro);
    }

    @PostMapping
    public ResponseEntity<LibroDTO> crearDato(@Valid @RequestBody LibroDTO libroDTO){
        LibroDTO libroCrear = iLibroService.crear(libroDTO);
        return ResponseEntity.created(URI.create("/api/books"+libroCrear.getId())).body(libroCrear);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibroDTO> actualizarLibro(@PathVariable Integer id,@RequestBody LibroDTO dto) {
        return ResponseEntity.ok(iLibroService.actualizarLibro(id,dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        iLibroService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<LibroDTO>> busquedaLibro(@RequestParam String termino){

        return ResponseEntity.ok(iLibroService.busquedaPorTermino(termino));
    }

}
