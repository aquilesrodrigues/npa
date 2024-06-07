package com.project.npa.model.dto;


import com.project.npa.model.CentroCusto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class CentroCustoDTO {
    private Long id;
    private String nome;

    public CentroCustoDTO(CentroCusto centroCusto){
        this.id = centroCusto.getId();
        this.nome = centroCusto.getNome();
    }

    public CentroCusto converteParaCentroCusto(){
        //var ══> Tipo Inferido
        var centroCusto = new CentroCusto();
        centroCusto.setId(this.id);
        centroCusto.setNome(this.nome);

        return centroCusto;
    }

    public Long getId() { return id;  }

    public String getNome() { return nome;  }

    public void setId(Long id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }

}
