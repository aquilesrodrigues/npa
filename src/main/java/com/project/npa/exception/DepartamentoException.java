package com.project.npa.exception;

public class DepartamentoException extends RuntimeException {

    public DepartamentoException( Long id) {
        super("Não foi possível achar o Departamento: "+ id);
    }
}
