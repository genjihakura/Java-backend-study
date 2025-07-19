package vn.vti.dtn2501.user.config.openapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.OAuthScope;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
//@SecurityScheme(
//    name = "bearerAuth",
//    type = SecuritySchemeType.HTTP,
//    scheme = "bearer",
//    bearerFormat = "JWT"
//)
//@SecurityScheme(
//    name = "basicAuth",
//    type = SecuritySchemeType.HTTP,
//    scheme = "basic"
//)
@OpenAPIDefinition(
    info = @Info(
        title = "User manager API",
        description = "User manager API documentation",
        version = "1.0"
    ),
    security = @SecurityRequirement(name = "oauth2_bearer")
)
@SecurityScheme(name = "oauth2_bearer", type = SecuritySchemeType.OAUTH2,
    flows = @OAuthFlows(
        authorizationCode = @OAuthFlow(
            authorizationUrl = "${springdoc.oauthflow.authorization-url}",
            tokenUrl = "${springdoc.oauthflow.token-url}",
            scopes = {@OAuthScope(name = "profile", description = "profile")
            })))
public class OpenApiConfig {

//  @Bean
//  public OpenAPI customOpenAPI() {
//    return new OpenAPI()
//        .info(new Info()
//            .title("User Manager API")
//            .version("1.0")
//            .description("This is User Manager API documentation with SpringDoc"))
//        .addServersItem(new Server().url("http://localhost:9090").description("Local Server"))
//        .addServersItem(new Server().url("http://localhost:8888/user").description("Production Server"));
//  }

}
