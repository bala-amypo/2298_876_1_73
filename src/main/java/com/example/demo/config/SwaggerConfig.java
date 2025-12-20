// package com.example.demo.config;

// import io.swagger.v3.oas.models.*;
// import io.swagger.v3.oas.models.security.*;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import io.swagger.v3.oas.models.info.Info;


// @Configuration
// public class SwaggerConfig {

//     @Bean
//     public OpenAPI openAPI() {
//         return new OpenAPI()
//                 .components(new Components()
//                         .addSecuritySchemes("bearer-jwt",
//                                 new SecurityScheme()
//                                         .type(SecurityScheme.Type.HTTP)
//                                         .scheme("bearer")
//                                         .bearerFormat("JWT")))
//                 .addSecurityItem(new SecurityRequirement().addList("bearer-jwt"))
//                 .info(new Info().title("Workflow Approval API").version("1.0"));
//     }
// }
