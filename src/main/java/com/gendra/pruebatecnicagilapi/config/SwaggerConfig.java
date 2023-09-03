package com.gendra.pruebatecnicagilapi.config;

import org.springframework.beans.factory.annotation.Value;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Value("${version}")
    private String appVersion;

    @Value("${user.role}")
    private String userRole;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gendra.pruebatecnicagilapi.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfoBuilder()
                .title("Prueba Técnica  - : " + userRole)
                .description("Esta API es una prueba técnica con la principal funcionalidad de traer información sobre ciudades.")
                .contact(new Contact("Gilberto García", "", "gilgasan1@gmail.com"))
                .version(appVersion)
                .build();
    }

}
