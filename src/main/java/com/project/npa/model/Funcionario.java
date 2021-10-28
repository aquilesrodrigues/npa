package com.project.npa.model;


import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="funcionario")

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
    @JoinColumn(name = "cargoId", nullable = false, foreignKey = @ForeignKey(name = "funcionario_cargo_fk"), unique = false)
    private Cargo cargo;


    @ManyToMany(mappedBy = "funcionarios")
    @OrderBy("nome asc")
    private List<Projeto> projetos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }
}
