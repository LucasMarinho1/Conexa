package com.example.prova_conexa.config;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2

public class SwaggerConfig {
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.prova_semear")).build()
				.apiInfo(metaInfo())
				.securitySchemes(Arrays.asList(apiKey()));
	}

	private ApiInfo metaInfo() {

		ApiInfo apiInfo = new ApiInfo("API RESTfull", "API REST", "1.0",
				"", new Contact("Lucas", "", ""), "", "",
				new ArrayList<VendorExtension>());

		return apiInfo;
	}
	
	private ApiKey apiKey() {
	    return new ApiKey("jwtToken", "Authorization", "header");
	}
}
