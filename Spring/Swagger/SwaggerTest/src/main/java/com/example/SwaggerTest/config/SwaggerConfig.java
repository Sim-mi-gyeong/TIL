package com.example.SwaggerTest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * Swagger-ui 에서 메인으로 보야질 내용 설
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SwaggerTest")
                .description("Swagger Test")
                .build();
    }

    /**
     * Docket : api 의 그룹명이나 이동경로, 보여질 api 가 속한 패키지 등의 자세한 정보 포함
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("swagger")
                .apiInfo(this.apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.example.SwaggerTest.controller"))   // Controller 의 Package Name
                .paths(PathSelectors.ant("/api/**"))
                .build();
    }

}
