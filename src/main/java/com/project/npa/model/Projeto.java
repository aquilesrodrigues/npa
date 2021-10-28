package com.project.npa.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name="projeto")

public class Projeto {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nome;

    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    private LocalDate dateInicio;

    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    private LocalDate dateFim;

    @Column(nullable = false)
    private Boolean status;

    @Column(nullable = false)
    private String flags;

    @ManyToOne
    @JoinColumn(name = "centroCustoId", nullable = false, foreignKey = @ForeignKey(name = "projeto_centroCusto_fk"), unique = false)
    private CentroCusto centroCusto;

    @ManyToOne
    @JoinColumn(name = "funcionarioGerenteId", nullable = false, foreignKey = @ForeignKey(name = "projeto_funcionario_fk"), unique = false)
    private Funcionario funcionarioGerente;

    @ManyToMany
    @JoinTable(
            name = "projeto_funcionario",
            joinColumns = @JoinColumn(
                    name= "projetoId", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "funcionarioId", referencedColumnName = "id"
            )
    )
    private Collection<Funcionario> funcionarios;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDateInicio() {
        return dateInicio;
    }

    public void setDateInicio(LocalDate dateInicio) {
        this.dateInicio = dateInicio;
    }

    public LocalDate getDateFim() {
        return dateFim;
    }

    public void setDateFim(LocalDate dateFim) {
        this.dateFim = dateFim;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getFlags() {
        return flags;
    }

    public void setFlags(String flags) {
        this.flags = flags;
    }

    public CentroCusto getCentroCusto() {
        return centroCusto;
    }

    public void setCentroCusto(CentroCusto centroCusto) {
        this.centroCusto = centroCusto;
    }

    public Collection<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Collection<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Funcionario getFuncionarioGerente() {
        return funcionarioGerente;
    }

    public void setFuncionarioGerente(Funcionario funcionarioGerente) {
        this.funcionarioGerente = funcionarioGerente;
    }
}
