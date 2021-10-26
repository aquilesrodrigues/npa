package com.project.npa.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name="projeto")
@Getter
@Setter
public class Projeto {

    @Id
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

}
