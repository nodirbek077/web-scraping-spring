package uz.trading.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class SwaggerConfig {


    @Bean
    public OpenAPI openAPI() {

        Info info = new Info()
                .title("Trading API")
                .version("1.0.0")
                .description("Trading API Documentation");
//                .contact(new Contact()
//                        .name("Nodir")
//                        .email("gmail.com")
//                        .url("https://t.me/nurqulovdev")
//                )
//                .license(new License()
//                        .name("Internal Product of Software Engineer")
//                        .url("https://trade.uz")
//                );

        SecurityRequirement securityRequirement = new SecurityRequirement();
        securityRequirement.addList("bearerAuth");

        SecurityScheme securityScheme = new SecurityScheme();
        securityScheme.setName("bearerAuth");
        securityScheme.setType(SecurityScheme.Type.HTTP);
        securityScheme.bearerFormat("JWT");
        securityScheme.setIn(SecurityScheme.In.HEADER);
        securityScheme.setScheme("bearer");

        Components components = new Components();
        components.addSecuritySchemes("bearerAuth", securityScheme);


        OpenAPI openAPI = new OpenAPI();
        openAPI.setInfo(info);
        openAPI.setSecurity(List.of(securityRequirement));
        openAPI.components(components);

        return openAPI;

    }
}
