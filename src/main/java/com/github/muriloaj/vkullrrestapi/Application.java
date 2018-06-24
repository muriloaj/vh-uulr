package com.github.muriloaj.vkullrrestapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.text.SimpleDateFormat;
import java.util.Date;

import static springfox.documentation.builders.PathSelectors.any;

@SpringBootApplication
@EnableSwagger2
@EnableScheduling
public class Application {

    @Value("${version}")
    private String version;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .forCodeGeneration(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.github.muriloaj.vkullrrestapi.controller.rest"))
                .paths(any()) // FOR DEVELOPMENT, CHANGE TO any() instead of regex()
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {

        String year = new SimpleDateFormat("yyyy").format(new Date());

        return new ApiInfo(
                "VH-Ullr Integration - (REST) API",
                "API focused in simplify the integration process for third part teams to our tool",
                version,
                "",
                "@muriloaj",
                String.format("(c) 2018 - %s by @muriloaj ", year),
                "-");
    }

}
