package com.project.npa.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.npa.model.Departamento;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartamentoDTO {

    private Long id;

    private String nome;

    private String descricao;

//    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private String date;

    public DepartamentoDTO(Departamento departamentoCadastro) {
        this.id = departamentoCadastro.getId();
        this.nome = departamentoCadastro.getNome();
        this.descricao = departamentoCadastro.getDescricao();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.date = departamentoCadastro.getDate().format(formater);
    }
    public Departamento toDepartamento() {
        var departamento = new Departamento();
        departamento.setNome(this.nome);
        departamento.setDescricao(this.descricao);
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        departamento.setDate(LocalDate.parse(this.date,formater ));
        return departamento;
    }
}
