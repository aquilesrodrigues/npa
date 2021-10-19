package com.project.npa;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    @Value("${app.message}")
    private String appMessage;

    @Value("${JAVA_HOME:NENHUMA}")
    private String variavelAmbiente;

    @GetMapping("/")
    public String getAppMessage() {
        return appMessage;
    }

    @GetMapping("/varAmbiente")
    public String getVariavelAmbiente() {
        return "A seguinte variável de ambiente foi passada" + variavelAmbiente;
    }
}
