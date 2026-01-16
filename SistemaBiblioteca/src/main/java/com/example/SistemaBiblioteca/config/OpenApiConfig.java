package com.example.SistemaBiblioteca.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPIPerso() {
    return new OpenAPI()
            .info(new Info()
                    .title("API Sistema de Gestión de Biblioteca")
                    .version("1.0.0")
                    .description("Documentación de la API de libros. Permite gestionar inventarios con los datos basicos de un libro" +
                            " como por ejemplo, el año de publicacion, el ISBN, entre otros."));
    }

}
