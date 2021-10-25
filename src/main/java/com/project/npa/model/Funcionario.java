package com.project.npa.model;



import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType.*;
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

    @Column(nullable = false)
    private Boolean status;

    @Column(length = 15)
    private String telefone;

    @Column(nullable = false)
    private String email;


    @ManyToOne
    @JoinColumn(name = "departamentoId", nullable = false, foreignKey = @ForeignKey(name = "funcionario_departamento_fk"), unique = false)
    private Departamento departamento;

    @ManyToOne
    //@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "cargoId", nullable = false, foreignKey = @ForeignKey(name = "funcionario_cargo_fk"), unique = false)
    private Cargo cargo;



}
