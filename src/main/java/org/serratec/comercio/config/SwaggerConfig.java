package org.serratec.comercio.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI comercioOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API - Comércio Varejista")
                        .description("Sistema de gerenciamento de pedidos, clientes e produtos do comércio varejista." 
                        		+ " **Grupo 5:** "
                        		+ "**João Menezes** |"
                        		+ "| **Willian Lippi** |"
                        		+ "| **José Arthur** |"
                        		+ "| **Nicole Parisi** |"
                        		+ "| **Nélio Ramos** |"
                        		+ "| **Gabriel Belinski** ||.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Equipe Serratec")
                                .email("contato@serratec.org")
                                .url("https://www.serratec.org"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentação completa no GitHub")
                        .url("https://github.com/joaommenezes-ctrl/serratec-Projeto-Final-API"));
    }
    //http://localhost:8080/swagger-ui/index.html#/
}
