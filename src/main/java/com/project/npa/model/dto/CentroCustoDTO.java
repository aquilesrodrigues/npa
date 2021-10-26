package com.project.npa.model.dto;


import com.project.npa.model.CentroCusto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CentroCustoDTO {
    private Long id;
    private String nome;

    public CentroCustoDTO(CentroCusto centroCusto){
        this.id = centroCusto.getId();
        this.nome = centroCusto.getNome();
    }

    public CentroCusto toCentroCusto(){
        var centroCusto = new CentroCusto();
        centroCusto.setId(this.id);
        centroCusto.setNome(this.nome);

        return centroCusto;
    }
}
