package com.example.onlineshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
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
                .select()
                .apis(RequestHandlerSelectors.any())//basePackage("kg.mega.demojpa")
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
}
