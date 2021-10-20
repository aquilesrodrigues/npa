package com.project.npa;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@Setter
@RestController
public class AppController {
    @Value("${app.message}")
    private String appMessage;

    @Value("${JAVA_HOME:NENHUMA}")
    private String variavelAmbiente;

    @GetMapping("/status")
    public String getAppMessage() {
        return appMessage;
    }
    @GetMapping("/caminhojava")
    public String getVariavelAmbiente() {
        return "O caminho da variável de ambiente é:   " + variavelAmbiente;
    }
}
