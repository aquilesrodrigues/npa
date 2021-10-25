package com.project.npa.model;



import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;

@Entity
@Table(name="funcionario")
@Getter
@Setter
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 14)
    private String cpf;

    @Column(nullable = false, length = 50)
    private String primeiroNome;

    @Column(nullable = false, length = 50)
    private String ultimoNome;

    private Boolean status;

    @Column(length = 15)
    private String telefone;

    @Column(nullable = false)
    private String email;


    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "departamentoId", referencedColumnName = "id")
    private Departamento departamento;

    @OneToOne
    @JoinColumn(name = "cargoId", referencedColumnName = "id")
    private Cargo cargo;


}
