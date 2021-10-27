package com.project.npa.model.dto;

import com.project.npa.model.CentroCusto;
import com.project.npa.model.Funcionario;
import com.project.npa.model.Projeto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjetoSimplesDTO {
    private Long id;
    private String nome;
    private String dateInicio;
    private String dateFim;
    private Boolean status;
    private String flags;
    private Long centroCustoId;
    private Collection<Long> funcionariosId;
    DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public ProjetoSimplesDTO(Projeto projeto) {

        this.id = projeto.getId();
        this.nome = projeto.getNome();
        this.dateInicio = projeto.getDateInicio().format(formater);
        this.dateFim = projeto.getDateFim().format(formater);
        this.status = projeto.getStatus();
        this.flags = projeto.getFlags();
        this.centroCustoId = projeto.getCentroCusto().getId();
        this.funcionariosId = new ArrayList<Long>();
        for (Funcionario item : projeto.getFuncionarios()) {
            this.funcionariosId.add(item.getId());

        }

    }

    public Projeto converteParaProjeto(CentroCusto centroCusto, Collection<Funcionario> funcionarios) {
        var projeto = new Projeto();
        projeto.setId(this.id);
        projeto.setNome(this.nome);
        projeto.setDateInicio(LocalDate.parse(this.dateInicio, formater));
        projeto.setDateFim(LocalDate.parse(this.dateFim, formater));
        projeto.setStatus(this.status);
        projeto.setFlags(this.flags);
        projeto.setCentroCusto(centroCusto);
        projeto.setFuncionarios(funcionarios);

        return projeto;

    }
}
