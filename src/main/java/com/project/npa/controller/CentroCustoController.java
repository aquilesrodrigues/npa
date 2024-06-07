package com.project.npa.controller;

import com.project.npa.exception.CentroCustoException;
import com.project.npa.model.CentroCusto;
import com.project.npa.model.dto.CentroCustoDTO;
import com.project.npa.repository.CentroCustoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CentroCustoController {

    private final String URLBASE = "/centrodecusto";
    private final String URLBASEID = URLBASE + "/{id}";

    @Autowired
    private CentroCustoRepository centroCustoRepository;

    @PostMapping(URLBASE)
    public ResponseEntity<CentroCustoDTO> cadastrar(@RequestBody CentroCustoDTO cargoDto) {

        CentroCusto centroCusto = cargoDto.converteParaCentroCusto();
        centroCusto = centroCustoRepository.save(centroCusto);

        return new ResponseEntity<>(new CentroCustoDTO(centroCusto), HttpStatus.CREATED);

    }

    @GetMapping(URLBASE)
    public ResponseEntity<List<CentroCustoDTO>> listar(){

        List<CentroCusto> centroCustos = centroCustoRepository.findAll();
        List<CentroCustoDTO> listagemCentroCusto = new ArrayList<>();

        for (CentroCusto item: centroCustos)
        {
            listagemCentroCusto.add(new CentroCustoDTO(item));
        }
        return new ResponseEntity<>(listagemCentroCusto, HttpStatus.OK);
    }

    @GetMapping(URLBASEID)
    public ResponseEntity<CentroCustoDTO> retorna(@PathVariable("id") Long id) {

        CentroCusto centroCusto = centroCustoRepository.findById(id).orElseThrow(() -> new CentroCustoException(id));

        return new ResponseEntity<>(new CentroCustoDTO(centroCusto), HttpStatus.OK);
    }

    @PutMapping(URLBASEID)
    public ResponseEntity<CentroCustoDTO> editarCentroCusto(@PathVariable("id") Long id, @RequestBody CentroCustoDTO centroCustoDto){

        CentroCusto centroCusto = centroCustoRepository.findById(id).orElseThrow(() -> new CentroCustoException(id));
        centroCusto = centroCustoDto.converteParaCentroCusto();
        centroCusto.setId(id);
        centroCusto = centroCustoRepository.save(centroCusto);

        return new ResponseEntity<>(new CentroCustoDTO(centroCusto), HttpStatus.OK);
    }

    @DeleteMapping(URLBASEID)
    public ResponseEntity<?> deletar(@PathVariable Long id){
        CentroCusto centroCusto = centroCustoRepository.findById(id).orElseThrow(() -> new CentroCustoException(id));
        centroCustoRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
