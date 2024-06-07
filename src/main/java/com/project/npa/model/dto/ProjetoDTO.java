package com.project.npa.model.dto;

import com.project.npa.model.Funcionario;
import com.project.npa.model.Projeto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjetoDTO {
    private Long id;
    private String nome;
    private LocalDate dateInicio;
    private LocalDate dateFim;
    private Boolean status;
    private String flags;
    private CentroCustoDTO centroCusto;
    private Collection<FuncionarioDTO> funcionarios;

    public ProjetoDTO(Projeto projeto) {
        this.id = projeto.getId();
        this.nome = projeto.getNome();
        this.dateInicio = projeto.getDateInicio();
        this.dateFim = projeto.getDateFim();
        this.status = projeto.getStatus();
        this.flags = projeto.getFlags();
        this.centroCusto = new CentroCustoDTO(projeto.getCentroCusto());
        this.funcionarios = new ArrayList<FuncionarioDTO>();
        for (Funcionario item : projeto.getFuncionarios()) {
            this.funcionarios.add(new FuncionarioDTO(item));

        }
    }

    public Projeto converteParaProjeto() {
        var projeto = new Projeto();
        projeto.setId(this.id);
        projeto.setNome(this.nome);
        projeto.setDateInicio(this.dateInicio);
        projeto.setDateFim(this.dateFim);
        projeto.setStatus(this.status);
        projeto.setFlags(this.flags);
        projeto.setCentroCusto(this.centroCusto.converteParaCentroCusto());
        projeto.setFuncionarios(new ArrayList<Funcionario>());
        for (FuncionarioDTO item : this.funcionarios)
        {
            projeto.getFuncionarios().add(item.toFuncionario());

        }

        return projeto;
    }

}
