package com.project.npa.controller;


import com.project.npa.model.Departamento;
import com.project.npa.model.dto.DepartamentoDTO;
import com.project.npa.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartamentoController {

    private final String URLBASE = "/departamentos";

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @PostMapping(URLBASE)
    public ResponseEntity<DepartamentoDTO> cadastrar(@RequestBody DepartamentoDTO departamento){

        Departamento departamentoCadastro = departamento.getDepartamento();
        departamentoCadastro = departamentoRepository.save(departamentoCadastro);

        return new ResponseEntity<>(new DepartamentoDTO(departamentoCadastro), HttpStatus.CREATED);
    }

}
