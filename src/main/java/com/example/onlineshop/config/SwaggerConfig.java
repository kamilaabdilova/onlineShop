package com.example.onlineshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
public class SwaggerConfig {
    static String BEARER_AUTH = "Bearer";
    public static final String BASKET = "Корзина";
    public static final String BRAND = "Бренд";
    public static final String CATEGORY = "Категория";
    public static final String ORDER = "Заказ";
    public static final String PRODUCT = "Продукт";
    public static final String STATUS = "Статус";
    public static final String USER = "Пользователь";
    public static final String AUTH = "Авторизация";
    public static final String MAIL = "Отправка email";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.onlineshop"))
//                .basePackage("com.example.onlineshop")
//                .any()
                .paths(PathSelectors.any())
                .build()

                .tags(new Tag(USER,""))
                .tags(new Tag(BASKET,""))
                .tags(new Tag(BRAND,""))
                .tags(new Tag(CATEGORY,""))
                .tags(new Tag(PRODUCT,""))
                .tags(new Tag(ORDER,""))
                .tags(new Tag(STATUS,""))
                .tags(new Tag(AUTH,""))
                .tags(new Tag(MAIL,""));
    }
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "My REST API",
                "Some custom description of API.",
                "1.0",
                "Terms of service",
                new Contact("Sallo Szrajbman", "www.baeldung.com", "salloszraj@gmail.com"),
                "License of API",
                "API license URL",
                Collections.emptyList());
    }
    private ApiKey apiKey() {
        return new ApiKey("JWT", "Authorization", "header");
    }
    private SecurityContext securityContext() {
        return SecurityContext
                .builder()
                .securityReferences((List<SecurityReference>) defaultAuth())
                .build();
    }
    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    }
}
