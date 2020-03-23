package com.crudpessoas;

import com.crudpessoas.core.web.ApiProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ApiProperty.class)
public class CrudpessoasApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudpessoasApplication.class, args);
    }

}
