package com.example.SistemaBiblioteca.exception;

// la clase de la excepcion de Conflic y su metodo
public class ConflictException extends RuntimeException{
    public ConflictException(String mensaje){
        super(mensaje);
    }
}
