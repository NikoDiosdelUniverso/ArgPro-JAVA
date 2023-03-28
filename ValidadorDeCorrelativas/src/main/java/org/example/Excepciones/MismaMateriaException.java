package org.example.Excepciones;

public class MismaMateriaException extends RuntimeException {
    public MismaMateriaException(String mensaje) {
        super(mensaje);
    }
}
