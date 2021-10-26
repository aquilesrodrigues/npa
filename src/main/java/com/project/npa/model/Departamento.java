package com.project.npa.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="departamento")
@Data
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(nullable = false, length = 150)
    private String nome;

    @Column(length = 150)
    private String descricao;

    //@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    private LocalDate date;


    @OneToMany(mappedBy = "departamento")
    @OrderBy("nome asc")
    private List<Funcionario> funcionario;
}
