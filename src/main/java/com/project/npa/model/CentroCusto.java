package com.project.npa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="centroCusto")

public class CentroCusto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nome;

    @OneToMany(mappedBy = "centroCusto")
    private List<Projeto> projetos;



    public Long getId() { return id; }

    public String getNome() { return nome; }

    public List<Projeto> getProjetos() { return projetos; }


    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }
}
