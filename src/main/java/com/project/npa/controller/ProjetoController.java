package com.project.npa.controller;


import com.project.npa.exception.CentroCustoException;
import com.project.npa.exception.FuncionarioException;
import com.project.npa.model.CentroCusto;
import com.project.npa.model.Funcionario;
import com.project.npa.model.Projeto;
import com.project.npa.model.dto.ProjetoSimplesDTO;
import com.project.npa.repository.CentroCustoRepository;
import com.project.npa.repository.FuncionarioRepository;
import com.project.npa.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

@RestController
public class ProjetoController {

    private final String URLBASE = "/projetos";
    private final String URLBASEID = URLBASE + "/{id}";

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private CentroCustoRepository centroCustoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @PostMapping(URLBASE)
    public ResponseEntity<ProjetoSimplesDTO> cadastro(@RequestBody ProjetoSimplesDTO projetoSimples) {

        CentroCusto centroCusto = centroCustoRepository.findById(projetoSimples.getCentroCustoId()).orElseThrow(() -> new CentroCustoException(projetoSimples.getCentroCustoId()));
        Collection<Funcionario> funcionarios = new ArrayList<Funcionario>();
        for (Long id : projetoSimples.getFuncionariosId()) {

            Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(() -> new FuncionarioException(id));
            funcionarios.add(funcionario);
        }

        Projeto projetoCadastro = projetoSimples.converteParaProjeto(centroCusto, funcionarios);
        projetoCadastro = projetoRepository.save(projetoCadastro);

        return new ResponseEntity<ProjetoSimplesDTO>(new ProjetoSimplesDTO(projetoCadastro), HttpStatus.CREATED);
    }


}
