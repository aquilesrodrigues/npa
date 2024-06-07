package com.project.npa.exception;

public class FuncionarioException extends RuntimeException {
    public FuncionarioException(Long id) {
        super("Não foi possível achar o Funcionario: "+ id);
    }
}
