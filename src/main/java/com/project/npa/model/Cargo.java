package com.project.npa.model;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="cargo")
@Getter
@Setter
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @OneToMany(mappedBy="cargo")

    private List<Funcionario> funcionarios;

    public void addFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

}
