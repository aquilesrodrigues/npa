package com.project.npa.exception;

public class ProjetoException extends RuntimeException{

    public ProjetoException(Long id) {

        super("Não foi possível achar o Projeto" + id);
    }
}
