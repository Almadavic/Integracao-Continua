package com.almada.manage_people.config.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {

        return GroupedOpenApi.builder()
                .group("ManagePeopleAPI")
                .pathsToMatch("/**")
                .build();

    }

    @Bean
    public OpenAPI publicAPISettings() {

        return new OpenAPI()
                .info(new Info().title("ManagePeopleAPI")
                        .description("It is a project to manage people.")
                        .version("v0.0.1")
                        .license(new License().name("Spring Doc").url("https://springdoc.org")))
                .components(new Components().addSecuritySchemes("bearer-key", new SecurityScheme().type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")))
                .externalDocs(new ExternalDocumentation())
                ;

    }

}
