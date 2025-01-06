package io.hhplus.serverconstruction.support

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import io.swagger.v3.oas.models.servers.Server
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
@OpenAPIDefinition(
    info = io.swagger.v3.oas.annotations.info.Info(
        title = "콘서트 예약 서비스 API",
        version = "1.0",
    )
)
class SwaggerConfig : WebMvcConfigurer {
    @Bean
    fun openAPI(): OpenAPI {

        return OpenAPI()
//            .addSecurityItem(
//                SecurityRequirement().addList("Bearer Authentication")
//            )
            .components(
                Components()
            )
            .addServersItem(Server().url("/"))
            .info(
                io.swagger.v3.oas.models.info.Info().title("콘서트 예약 서비스 API")
                    .description("콘서트 예약 서비스 API Spec")
                    .version("v1.0.0")
            )
    }

//    fun createAPIKeyScheme(): SecurityScheme? {
//        return SecurityScheme().type(SecurityScheme.Type.HTTP)
//            .bearerFormat("JWT")
//            .scheme("bearer")
//    }
}