package com.example.SistemaBiblioteca.exception;

// Clase de notFound con su metodo
public class NotFoundException extends RuntimeException {
    public NotFoundException(String mensaje){
        super(mensaje);
    }
}
