package com.project.npa.exception;

import com.project.npa.model.CentroCusto;
import org.springframework.data.jpa.repository.JpaRepository;

public class CentroCustoException extends RuntimeException{

    public CentroCustoException(Long id) {
        super("Não foi possível achar o Centro de Custo" + id);
    }
}
