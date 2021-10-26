package com.project.npa.controller;

import com.project.npa.model.CentroCusto;
import com.project.npa.model.dto.CentroCustoDTO;
import com.project.npa.repository.CentroCustoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CentroCustoController {

    private final String URLBASE = "/centrodecusto";
    private final String URLBASEID = URLBASE + "/{id}";

    @Autowired
    private CentroCustoRepository centroCustoRepository;

    public ResponseEntity<CentroCustoDTO> cadastrar(@RequestBody CentroCustoDTO cargo) {

        CentroCusto centroCusto = cargo.converteParaCentroCusto();
        centroCusto = centroCustoRepository.save(centroCusto);
    }
}
