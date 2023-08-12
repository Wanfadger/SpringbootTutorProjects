package com.wanfadger.QueryCriteria.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Project Management",
                description = "API exposing endpoints for project management",
                termsOfService = "free for any use",
                version="0.0.1",
                contact = @Contact(
                        name = "Galiwango Fahad",
                        url = "https://wanfadger.netlify.app/",
                        email = "galiwango.fahad@gmail.com"
                )
        )
)
public class OpenApiConfig {

}
