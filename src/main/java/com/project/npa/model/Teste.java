package com.project.npa.model;

import javax.persistence.*;

@Entity
@Table(name= "cachorro")
public class Teste {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String descricao;
}
