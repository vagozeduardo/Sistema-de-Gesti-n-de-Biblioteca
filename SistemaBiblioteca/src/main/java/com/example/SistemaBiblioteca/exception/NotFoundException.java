package com.example.SistemaBiblioteca.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String mensaje){
        super(mensaje);
    }
}
