package com.propertysearchsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
// import springfox.documentation.builders.PathSelectors;
// import springfox.documentation.builders.RequestHandlerSelectors;
// import springfox.documentation.service.ApiKey;
// import springfox.documentation.service.AuthorizationScope;
// import springfox.documentation.service.SecurityReference;
// import springfox.documentation.spi.DocumentationType;
// import springfox.documentation.spi.service.contexts.SecurityContext;
// import springfox.documentation.spring.web.plugins.Docket;
// import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;
@SpringBootApplication
public class PropertysearchsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropertysearchsystemApplication.class, args);
	}

	// private ApiKey apiKey() {
	// 	return new ApiKey("JWT", "Authorization", "header");
	// }

	// private List<SecurityReference> defaultAuth() {
	// 	AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
	// 	AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
	// 	authorizationScopes[0] = authorizationScope;
	// 	return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
	// }
	// private SecurityContext securityContext() {
	// 	return SecurityContext.builder().securityReferences(defaultAuth()).build();
	// }
	// @Bean
	// public Docket configureSwagger2() {
	// 	return new Docket(DocumentationType.SWAGGER_2).securityContexts(Arrays.asList(securityContext()))
	// 			.securitySchemes(Arrays.asList(apiKey()))
	// 			.select()
	// 			.paths(PathSelectors.any())
	// 			.apis(RequestHandlerSelectors.basePackage("com.propertysearchsystem"))
	// 			.build();
	// }



}
