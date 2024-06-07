package com.project.npa.exception;

public class CargoException extends RuntimeException {
    public CargoException(Long id) {
        super("Não foi possível achar o Cargo"+ id);
    }
}
