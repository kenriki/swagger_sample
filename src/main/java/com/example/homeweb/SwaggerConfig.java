package com.example.homeweb;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {

	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder()
				.group("springshop-public")
				.pathsToMatch("/public/**")
				.build();
	}

	@Bean
	public GroupedOpenApi adminApi() {
		return GroupedOpenApi.builder()
				.group("springshop-admin")
				.pathsToMatch("/user/**")
				.build();
	}

	@Bean
	public OpenAPI springShopOpenAPI() {
		return new OpenAPI().components(new Components()
				.addSecuritySchemes("basicScheme", new SecurityScheme()
				.type(SecurityScheme.Type.HTTP).scheme("basic")))
				.info(new Info().title("SpringShop API")
						.description("Spring shop sample application")
						.version("v0.0.1")
						.license(new License().name("Apache 2.0").url("http://springdoc.org")))

				.externalDocs(new ExternalDocumentation()
						.description("SpringShop Wiki Documentation")
						.url("https://springshop.wiki.github.org/docs"));
	}
}