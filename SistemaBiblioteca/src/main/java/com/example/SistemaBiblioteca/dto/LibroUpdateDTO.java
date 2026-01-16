package com.example.SistemaBiblioteca.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema (description = "Es la representacion del model/entity para manejar" +
        " los datos mediante el Data Transfer Object, en este caso para validar las variables para actualizar")
public class LibroUpdateDTO {

    @Positive(message = "El ID debe ser un número positivo")
    private Integer id;

    @Schema(example = "Don Quijote de la Mancha", description = "Nombre del libro")
    private String titulo;


    @Schema(example = "Miguel de Cervantes",description = "Autor del libro")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$", message = "El nombre solo debe contener letras")
    private String autor;

    @Schema(example = "9788420412146", description = "Código ISBN único de 10 o 13 dígitos")
    @Pattern(regexp = "^\\d{10,13}$", message = "El ISBN debe tener entre 10 y 13 dígitos")
    private String ISBN;

    @Schema(example = "-800", description = "Año de publicación. Use valores negativos para fechas AC (ej. -800 para La Odisea)")
    @Min(value = -3000, message = "El año es demasiado antiguo")
    @Max(value = 2026, message = "El año no puede ser mayor al actual")
    private Integer anioPublicacion;

    @Schema(example = "Ciencia Ficción",description = "La categoria a la que pertenece el libro")
    private String genero;

    @Schema(example = "13",description = "Es de tipo numerico asi que no puede recibir texto como tambien no puede recibir numeros menores a 0")
    @Min(value = 0, message = "El stock no puede ser negativo")
    @PositiveOrZero(message = "La cantidad debe ser un número entero positivo")
    private Integer cantidadDisponible;


    // validar si el DTO tiene datos o no
    // usado para actualizar
    @JsonIgnore
    public boolean isTotalmenteVacio() {
        return titulo == null && autor == null && ISBN == null && anioPublicacion == null && genero == null && cantidadDisponible == null;
    }

}
