package com.project.npa.controller;


import com.project.npa.model.Departamento;
import com.project.npa.model.dto.DepartamentoDTO;
import com.project.npa.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DepartamentoController {

    private final String URLBASE = "/departamentos";

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @PostMapping(URLBASE)
    public ResponseEntity<DepartamentoDTO> cadastrar(@RequestBody DepartamentoDTO departamento){

        Departamento departamentoCadastro = departamento.toDepartamento();
        departamentoCadastro = departamentoRepository.save(departamentoCadastro);

        return new ResponseEntity<>(new DepartamentoDTO(departamentoCadastro), HttpStatus.CREATED);
    }

    @GetMapping(URLBASE)
    public ResponseEntity<List<DepartamentoDTO>> listar(){

        List<Departamento> departamentoLista = departamentoRepository.findAll();
        List<DepartamentoDTO> listagemDepartamentos = new ArrayList<>();
//        departamentoLista.stream().map(item -> listagemDepartamentos.add(new DepartamentoDTO(item)));
        for (Departamento item :
                departamentoLista) {
            listagemDepartamentos.add(new DepartamentoDTO(item));
        }
        for (DepartamentoDTO item :
                listagemDepartamentos) {
            System.out.println(item.getNome());;
        }
        return new ResponseEntity<>(listagemDepartamentos, HttpStatus.OK);
    }
}
