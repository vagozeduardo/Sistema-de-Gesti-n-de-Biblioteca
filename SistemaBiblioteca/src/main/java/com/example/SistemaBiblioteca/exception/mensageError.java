package com.example.SistemaBiblioteca.exception;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class mensageError {
    @Schema(description = "Variable para guardar el tipo de error o status generado")
    private HttpStatus status;
    @Schema(description = "mensaje que se desea enviar")
    private String message;
}
