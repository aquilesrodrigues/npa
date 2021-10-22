package com.project.npa.model;


import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="funcionario")
@Data
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String cpf;

    @NotNull
    private String primeiroNome;

    @NotNull
    private String ultimoNome;

    @NotNull
    private Boolean status;

    private String telefone;

    private String email;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "departamento_id", nullable = false)
    private Departamento departamento;


}
