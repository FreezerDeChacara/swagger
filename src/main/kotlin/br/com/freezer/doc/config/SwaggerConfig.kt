package br.com.freezer.doc.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors.any
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.*


@Configuration
@EnableSwagger2
open class SwaggerConfig(@Value("\${config.swagger.path:br.com.freezer.doc.controller}") private val pathSwagger: String) {

    @Bean
    open fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage(pathSwagger))
            .paths(any())
            .build()
            .apiInfo(apiInfo())
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfo(
            "Integração de veículos",
            "Integração de veículos automotores",
            "API 0.1.0.0",
            "http://sqldofreezer.blogspot.com.br/",
            Contact("Marco Antonio Bidóia", "http://sqldofreezer.blogspot.com.br/", "marco.bidoia@gmail.com"),
            "License of API", "http://sqldofreezer.blogspot.com.br/", Collections.emptyList()
        )
    }
}