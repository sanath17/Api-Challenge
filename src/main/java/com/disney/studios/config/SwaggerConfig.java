package com.disney.studios.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	private static final String DOG_API_VERSION = "1.0";
	private static final String Dog_License = "Licensed by SanathMaduri";
	private static final String Dog_title = "Dog REST API";
	private static final String Dog_description = "REST API for dog application";

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(Dog_title).description(Dog_description).license(Dog_License)
				.version(DOG_API_VERSION).build();
	}

	@Bean
	public Docket dogApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).pathMapping("/").select()
				.apis(RequestHandlerSelectors.basePackage("com.disney.studios")).paths(PathSelectors.regex("/api.*"))
				.build();
	}

}
