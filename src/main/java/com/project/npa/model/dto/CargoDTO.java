package com.project.npa.model.dto;

import com.project.npa.model.Cargo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CargoDTO {

    private Long id;
    private String nome;

    public CargoDTO(Cargo cargoCadastro) {
        this.id = cargoCadastro.getId();
        this.nome = cargoCadastro.getNome();
    }
    public Cargo converteParaCargo() {
        var cargo = new Cargo();
        cargo.setId(this.id);
        cargo.setNome(this.nome);
        return cargo;
    }
}
