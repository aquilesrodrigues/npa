package com.project.npa.model.dto;


import com.project.npa.model.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private CargoDTO cargo;

    public FuncionarioDTO(Funcionario funcionario) {
        this.id = funcionario.getId();
        this.cpf = funcionario.getCpf();
        this.departamento = new DepartamentoDTO(funcionario.getDepartamento());
        this.email = funcionario.getEmail();
        this.primeiroNome = funcionario.getPrimeiroNome();
        this.ultimoNome = funcionario.getUltimoNome();
        this.status = funcionario.getStatus();
        this.telefone = funcionario.getTelefone();
        this.cargo = new CargoDTO(funcionario.getCargo());

    }

    public Funcionario toFuncionario() {
        var funcionario = new Funcionario();
        funcionario.setId(this.id);
        funcionario.setCpf(this.cpf);
        funcionario.setPrimeiroNome(this.primeiroNome);
        funcionario.setUltimoNome(this.ultimoNome);
        funcionario.setStatus(this.status);
        funcionario.setTelefone(this.telefone);
        funcionario.setEmail(this.email);
        funcionario.setCargo(this.cargo.converteParaCargo());
        funcionario.setDepartamento(this.departamento.toDepartamento());

        return funcionario;


    }
}
