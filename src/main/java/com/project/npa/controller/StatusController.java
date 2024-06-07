package com.project.npa.controller;

import lombok.Data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
public class StatusController {
    @Value("${app.message}") // app.message está declarado em application-dev.yml
    private String appMessage;

    @Value("${JAVA_HOME:NENHUMA}")
    private String variavelAmbiente;


    @GetMapping(path = "/status")
    public String getAppMessage() {

        return appMessage;
    }

    @GetMapping(path = "/caminhojava")
    public String getVariavelAmbiente() {

        return "O caminho da variável de ambiente é:   " + variavelAmbiente;
    }
}
