package vn.vti.dtn2501.notification.config.security;

import java.util.List;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

public class CorsConfig {
  public static Customizer<CorsConfigurer<HttpSecurity>> configCorsCustomizer() {
    return c -> {
      CorsConfigurationSource source = request -> {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(
            List.of("http://localhost:3000", "http://localhost:8082"));
        config.setAllowedMethods(
            List.of("GET", "POST", "PUT", "DELETE"));
        config.setAllowedHeaders(List.of("*"));
        return config;
      };
      c.configurationSource(source);
    };
  }
}
