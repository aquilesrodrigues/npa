package com.project.npa.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@Getter
@Setter
public class DBConfiguration {
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    @Profile("dev")
    @Bean
    public String developmentDatabaseConnection() {
        System.out.println("DB connection for DEV - PostgreSQL");
        System.out.println(driverClassName);
        System.out.println(url);
        return "Return Connection to PostgreSQL_DEV - heroku nuvem";
    }
    @Profile("prod")

    public String productionDatabaseConnection() {
        System.out.println("DB connection for PROD - PostgreSQL");
        System.out.println(driverClassName);
        System.out.println(url);
        return "Return Connection to PostgreSQL_PROD - heroku nuvem";
    }
}
