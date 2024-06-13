package com.stock_manager.stock_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
public class StockManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockManagerApplication.class, args);
	}
    @Bean
    public OpenAPI customOpenAPI() {
        // final String securitySchemeName = "bearerAuth";
        final String apiTitle = "Stock API";
        return new OpenAPI()
            // .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
            // // .components(
            // //     // new Components()
            // //     //     .addSecuritySchemes(securitySchemeName,
            // //     //         new SecurityScheme()
            // //     //             .name(securitySchemeName)
            // //     //             .type(SecurityScheme.Type.HTTP)
            // //     //             .scheme("bearer")
            // //     //             .bearerFormat("JWT")
            // //     //     )
            // // )
            .info(new Info().title(apiTitle).version("0.0.1-SNAPSHOT"));
    }
}
