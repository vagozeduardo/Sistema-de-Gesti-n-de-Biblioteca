package com.example.SistemaBiblioteca.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LibroDTO {

    private Integer id;

    @NotBlank(message = "El título es obligatorio")
    private String titulo;

    @NotBlank(message = "El autor es obligatorio")
    private String autor;

    @NotBlank(message = "El ISBN es obligatorio")
    @Pattern(regexp = "^\\d{10,13}$", message = "El ISBN debe tener entre 10 y 13 dígitos")
    private String ISBN;

    @NotNull(message = "El año es obligatorio")
    @Min(value = -3000, message = "El año es demasiado antiguo")
    @Max(value = 2026, message = "El año no puede ser mayor al actual")
    private Integer anioPublicacion;

    @NotBlank(message = "El genero es olbigatorio")
    private String genero;

    @Min(value = 0, message = "El stock no puede ser negativo")
    private Integer cantidadDisponible;

}
