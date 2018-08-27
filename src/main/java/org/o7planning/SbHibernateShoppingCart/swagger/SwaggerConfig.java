/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.o7planning.SbHibernateShoppingCart.swagger;

/**
 *
 * @author archange
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
   
	@Bean
	  public static PropertySourcesPlaceholderConfigurer swaggerProperties() {
	    PropertySourcesPlaceholderConfigurer properties = new PropertySourcesPlaceholderConfigurer();
	    return properties;
	}
	
	@Bean
	public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.o7planning.SbHibernateShoppingCart.controller"))
                .paths(regex("/accounts/*"))
                .build()
                .apiInfo(metaData());
    }
    private ApiInfo metaData() {
        /*ApiInfo apiInfo;
            apiInfo = new ApiInfo(
                    "Spring Boot REST API",
                    "Spring Boot REST API for Online Store",
                    "1.0",
                    "Terms of service",
                    //new Contact("John Thompson", "https://springframework.guru/about/", "john@springfrmework.guru"),
                    "Apache License Version 2.0",
                    "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;*/
        Contact contact = new Contact("Rintio", "www.rintio.com", "michel@rintio.io");
        ApiInfoBuilder apiInfo = new ApiInfoBuilder();
        return apiInfo
                .title("Rest service")
                .description("This project is for rintio institute")
                .termsOfServiceUrl("http://example.com/terms-of-service")
                .contact(contact)
                .license("MIT License").licenseUrl("http://opensource.org/licenses/MIT").build();
    }
}