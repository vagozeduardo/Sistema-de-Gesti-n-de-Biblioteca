package com.example.SistemaBiblioteca.controller;


import com.example.SistemaBiblioteca.dto.LibroDTO;
import com.example.SistemaBiblioteca.dto.LibroUpdateDTO;
import com.example.SistemaBiblioteca.service.ILibroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
@Tag(name = "Libros", description = "Operaciones para la gestión de los libros")
@Validated
public class LibroController {

    @Autowired
    ILibroService iLibroService;

    @Operation(summary = "Traer todos libros(datos)", description = "Se trae todos los datos de la base")
    @GetMapping
    public ResponseEntity<Page<LibroDTO>> obtenerLibros(
            @PageableDefault(page = 0, size = 5) Pageable pageable) {
        return ResponseEntity.ok(iLibroService.traerDatos(pageable));
    }

    @Operation(summary = "Buscar libro por el \"id\"", description = "Se busca el libro(Dato) en la base " +
            " con el id que se ingreso")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Si el libro no es encontrado marca" +
                    "error 404 de que no existe el dato"),
            @ApiResponse(responseCode = "200", description = "Devuelve el codigo 200 si el dato es encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Optional<LibroDTO>> obtenerPorId(@PathVariable Integer id) {
        Optional<LibroDTO> libro = iLibroService.traerPorId(id);
        return ResponseEntity.ok(libro);
    }


    @Operation(summary = "Crear un libro", description = "Se crea un libro mediante los datos ingresados, si son validos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Libro creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error de validación en los datos enviados"),
            @ApiResponse(responseCode = "409", description = "El ISBN ya existe en el sistema")
    })
    @PostMapping
    public ResponseEntity<LibroDTO> crearDato(@Valid @RequestBody LibroDTO libroDTO) {
        LibroDTO libroCrear = iLibroService.crear(libroDTO);
        return ResponseEntity.created(URI.create("/api/books" + libroCrear.getId())).body(libroCrear);
    }


    @Operation(summary = "Actualizar un libro", description = "Permite la actualización parcial de un libro por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Libro actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "El libro con el ID proporcionado no existe"),
            @ApiResponse(responseCode = "409", description = "No se envio datos para actulizar")
    })
    @PutMapping("/{id}")
    public ResponseEntity<LibroUpdateDTO> actualizarLibro(
            @PathVariable Integer id,
            @Valid @RequestBody LibroUpdateDTO dto) {
        return ResponseEntity.ok(iLibroService.actualizarLibro(id, dto));
    }

    @Operation(summary = "Eliminar un libro", description = "Elimina el libro con el id ingresado")
    @ApiResponse(responseCode = "404", description = "Se marca como error 404 sin no se encuentra al " +
            " dato en la base")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        iLibroService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Buscar libro por parametro"
            , description = "Se busca el libro por el titulo o autor")
    @GetMapping("/search")
    public ResponseEntity<Page<LibroDTO>> busquedaLibro(
            @RequestParam(required = false) String termino,
            @PageableDefault(page = 0, size = 5) Pageable pageable) {
        return ResponseEntity.ok(iLibroService.busquedaPorTermino(termino,pageable));
    }

}
