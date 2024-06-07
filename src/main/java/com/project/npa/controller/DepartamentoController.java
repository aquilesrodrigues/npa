package com.project.npa.controller;


import com.project.npa.exception.DepartamentoException;
import com.project.npa.model.Departamento;
import com.project.npa.model.dto.DepartamentoDTO;
import com.project.npa.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DepartamentoController {

    private final String URLBASE = "/departamentos";
    private final String URLBASEID = URLBASE+"/{id}";

    @Autowired // faz injeção de dependência (será criada uma nova instância desta interface)
    private DepartamentoRepository departamentoRepository;

    //respostas formata respostas de api
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

        for (Departamento item :
                departamentoLista) {
            listagemDepartamentos.add(new DepartamentoDTO(item));
        }

        return new ResponseEntity<>(listagemDepartamentos, HttpStatus.OK);
    }
    @GetMapping(URLBASEID)
    public ResponseEntity<DepartamentoDTO> retornarDepartamento(@PathVariable("id")  Long id){

        Departamento departamento = departamentoRepository.findById(id).orElseThrow(() -> new DepartamentoException(id));

        return new ResponseEntity<>(new DepartamentoDTO(departamento), HttpStatus.OK);
    }

    @DeleteMapping(URLBASEID)
    public ResponseEntity<?> deletarDepartamento(@PathVariable Long id){

        Departamento departamento = departamentoRepository.findById(id).orElseThrow(() -> new DepartamentoException(id));
        departamentoRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }
    @PutMapping(URLBASEID)
    public ResponseEntity<DepartamentoDTO> editar(@PathVariable Long id, @RequestBody DepartamentoDTO departamentoDTO){

        Departamento edicaoDepartamento = departamentoRepository.findById(id).orElseThrow(() -> new DepartamentoException(id));
        edicaoDepartamento = departamentoDTO.toDepartamento();
        edicaoDepartamento.setId(id);
        edicaoDepartamento = departamentoRepository.save(edicaoDepartamento);

        return new ResponseEntity<>(new DepartamentoDTO(edicaoDepartamento), HttpStatus.OK);
    }


}
