package com.project.npa.controller;

import com.project.npa.exception.DepartamentoException;
import com.project.npa.exception.FuncionarioException;
import com.project.npa.model.Departamento;
import com.project.npa.model.Funcionario;
import com.project.npa.model.dto.DepartamentoDTO;
import com.project.npa.model.dto.FuncionarioDTO;
import com.project.npa.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class FuncionarioController {

    private final String URLBASE = "/funcionarios";
    private final String URLBASEID = URLBASE + "/{id}";

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    //respostas formata respostas de api
    @PostMapping(URLBASE)
    public ResponseEntity<FuncionarioDTO> cadastrar(@RequestBody FuncionarioDTO funcionarioDTO) {

        Funcionario funcionarioCadastro = funcionarioDTO.toFuncionario();
        funcionarioCadastro = funcionarioRepository.save(funcionarioCadastro);

        return new ResponseEntity<>(new FuncionarioDTO(funcionarioCadastro), HttpStatus.CREATED);
    }

    @GetMapping(URLBASE)
    public ResponseEntity<List<FuncionarioDTO>> listar() {

        List<Funcionario> funcionarioLista = funcionarioRepository.findAll();
        List<FuncionarioDTO> listagemFuncionarios = new ArrayList<>();

        for (Funcionario item :
                funcionarioLista) {
            listagemFuncionarios.add(new FuncionarioDTO(item));
        }

        return new ResponseEntity<>(listagemFuncionarios, HttpStatus.OK);
    }

    @GetMapping(URLBASEID)
    public ResponseEntity<FuncionarioDTO> retornarFuncionario(@PathVariable Long id) {

        Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(() -> new FuncionarioException(id));

        return new ResponseEntity<>(new FuncionarioDTO(funcionario), HttpStatus.OK);
    }

    @DeleteMapping(URLBASEID)
    public ResponseEntity<?> deletarFuncionario(@PathVariable Long id) {

        Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(() -> new FuncionarioException(id));
        funcionarioRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping(URLBASEID)
    public ResponseEntity<FuncionarioDTO> editar(@PathVariable Long id, @RequestBody FuncionarioDTO funcionarioDTO) {

        Funcionario edicaoFuncionario = funcionarioRepository.findById(id).orElseThrow(() -> new FuncionarioException(id));
        edicaoFuncionario = funcionarioDTO.toFuncionario();
        edicaoFuncionario.setId(id);
        edicaoFuncionario = funcionarioRepository.save(edicaoFuncionario);

        return new ResponseEntity<>(new FuncionarioDTO(edicaoFuncionario), HttpStatus.OK);
    }
}
