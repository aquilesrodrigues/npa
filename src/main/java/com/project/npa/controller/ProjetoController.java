package com.project.npa.controller;
import com.project.npa.exception.CentroCustoException;
import com.project.npa.exception.FuncionarioException;
import com.project.npa.exception.ProjetoException;
import com.project.npa.model.CentroCusto;
import com.project.npa.model.Funcionario;
import com.project.npa.model.Projeto;
import com.project.npa.model.dto.ProjetoSimplesDTO;
import com.project.npa.repository.CentroCustoRepository;
import com.project.npa.repository.FuncionarioRepository;
import com.project.npa.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        Funcionario funcionarioGerente = funcionarioRepository.findById(projetoSimples.getFuncionarioGerenteId()).orElseThrow(() -> new FuncionarioException(projetoSimples.getFuncionarioGerenteId()));

        Projeto projetoCadastro = projetoSimples.converteParaProjeto(centroCusto, funcionarios, funcionarioGerente);
        projetoCadastro = projetoRepository.save(projetoCadastro);

        return new ResponseEntity<ProjetoSimplesDTO>(new ProjetoSimplesDTO(projetoCadastro), HttpStatus.CREATED);
    }

    @PutMapping(URLBASEID)
    public ResponseEntity<ProjetoSimplesDTO> editar(@PathVariable Long id, @RequestBody ProjetoSimplesDTO projetoSimplesDto) {

        Long funcionarioGerenteId = projetoSimplesDto.getFuncionarioGerenteId();

        Projeto edicaoProjeto = projetoRepository.findById(id).orElseThrow(() -> new ProjetoException(id));
        Funcionario funcionarioGerente = funcionarioRepository.findById(funcionarioGerenteId).orElseThrow(() -> new FuncionarioException(funcionarioGerenteId));

        CentroCusto centroCusto = centroCustoRepository.findById(projetoSimplesDto.getCentroCustoId()).orElseThrow(() -> new CentroCustoException(projetoSimplesDto.getCentroCustoId()));
        
        edicaoProjeto = projetoSimplesDto.converteParaProjeto(centroCusto, edicaoProjeto.getFuncionarios(), funcionarioGerente);
        edicaoProjeto = projetoRepository.save(edicaoProjeto);

        return new ResponseEntity<>(new ProjetoSimplesDTO(edicaoProjeto), HttpStatus.OK);
    }


    @DeleteMapping(URLBASEID)
    public ResponseEntity<?> deletarProjeto(@PathVariable Long id) {

        Projeto projeto = projetoRepository.findById(id).orElseThrow(() -> new ProjetoException(id));
        projetoRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }


}
