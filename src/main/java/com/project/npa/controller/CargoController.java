package com.project.npa.controller;

import com.project.npa.exception.DepartamentoException;
import com.project.npa.model.Cargo;
import com.project.npa.model.Departamento;
import com.project.npa.model.dto.CargoDTO;
import com.project.npa.model.dto.DepartamentoDTO;
import com.project.npa.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class CargoController {

    private final String URLBASE = "/cargos";
    private final String URLBASEID = URLBASE + "/{id}";

    @Autowired
    private CargoRepository cargoRepository;

    @PostMapping(URLBASE)
    public ResponseEntity<CargoDTO> cadastrar(@RequestBody CargoDTO cargo) {

        Cargo cargoCadastro = cargo.toCargo();
        cargoCadastro = cargoRepository.save(cargoCadastro);

        return new ResponseEntity<>(new CargoDTO(cargoCadastro), HttpStatus.CREATED);
    }

    @GetMapping(URLBASE)
    public ResponseEntity<List<CargoDTO>> listar(){

        List<Cargo> cargoLista = cargoRepository.findAll();
        List<CargoDTO> listagemCargos = new ArrayList<>();

        for (Cargo item :
                cargoLista) {
            listagemCargos.add(new CargoDTO(item));
        }

        return new ResponseEntity<>(listagemCargos, HttpStatus.OK);
    }
    @GetMapping(URLBASEID)
    public ResponseEntity<CargoDTO> retornarCargo(@PathVariable("id") Long id) {

        Cargo cargo = cargoRepository.findById(id).orElseThrow(() -> new DepartamentoException(id));

        return new ResponseEntity<>(new CargoDTO(cargo), HttpStatus.OK);
    }

}
