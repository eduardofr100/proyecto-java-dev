package com.example.proyectoJavaDev.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ForwardedHeaderFilter;

import java.util.ArrayList;
import java.util.List;

@Configuration
@OpenAPIDefinition(
        servers = {
                @Server(url = "http://localhost:8080", description = "Ambiente de desarrollo")
        })
public class OpenApiConfig {

    private final List<Tag> tags = new ArrayList<>(
            List.of(new Tag().name("MELTSAN").description("Servicios de consulta de Meltsan"))
    );

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("auth", securityScheme()))
                .addSecurityItem(new SecurityRequirement().addList("auth"))
                .tags(tags)
                .info(apiInfo());
    }

    @Bean
    ForwardedHeaderFilter forwardedHeaderFilter() {
        return new ForwardedHeaderFilter();
    }

    private Info apiInfo() {
        return new Info()
                .title("MELTSAN API")
                .description("Web API")
                .contact(new Contact().email("raul.lopez@meltsan.com").name("Meltsan Team"))
                .license(new License().name("Meltsan Solutions 2021").url("https://www.meltsan.com/"))
                .version("0.0.1");
    }


    private SecurityScheme securityScheme() {
        SecurityScheme securityScheme = new SecurityScheme();
        securityScheme.setType(SecurityScheme.Type.APIKEY);
        securityScheme.scheme("bearer");
        securityScheme.bearerFormat("JWT");
        securityScheme.name("Authorization");
        securityScheme.in(SecurityScheme.In.HEADER);
        return securityScheme;
    }

}
