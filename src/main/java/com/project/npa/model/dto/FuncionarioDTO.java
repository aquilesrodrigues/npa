package com.project.npa.model.dto;

import com.project.npa.model.Departamento;
import com.project.npa.model.Funcionario;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDTO {

    private Long id;
    private String cpf;
    private String primeiroNome;
    private String ultimoNome;
    private Boolean status;
    private String telefone;
    private String email;
    private DepartamentoDTO departamento;

    public FuncionarioDTO(Funcionario funcionario) {
        this.id = funcionario.getId();
        this.cpf = funcionario.getCpf();
        this.departamento = new DepartamentoDTO(funcionario.getDepartamento());
        this.email = funcionario.getEmail();
        this.primeiroNome = funcionario.getPrimeiroNome();
        this.ultimoNome = funcionario.getUltimoNome();
        this.status = funcionario.getStatus();
        this.telefone = funcionario.getTelefone();

    }

    public Funcionario toFuncionario() {
        var funcionario = new Funcionario();
        funcionario.setCpf(this.cpf);
        funcionario.setPrimeiroNome(this.primeiroNome);
        funcionario.setUltimoNome(this.ultimoNome);
        funcionario.setStatus(this.status);
        funcionario.setTelefone(this.telefone);
        funcionario.setEmail(this.email);
        funcionario.setDepartamento(this.departamento.toDepartamento());
        return funcionario;


    }
}
