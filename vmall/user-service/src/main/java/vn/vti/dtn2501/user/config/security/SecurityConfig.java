package vn.vti.dtn2501.user.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import vn.vti.dtn2501.user.repository.UserRepository;
import vn.vti.dtn2501.user.service.VMallUserDetailsService;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {
  private final UserRepository userRepository;

  @Bean
  public UserDetailsService userDetailsService() {
    return new VMallUserDetailsService(userRepository);
  }


  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
    return authConfig.getAuthenticationManager();
  }

  @Bean
  @Order(2)
  public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)
      throws Exception {
    http.csrf(AbstractHttpConfigurer::disable);
    http
        .cors(CorsConfig.configCorsCustomizer())
        .authorizeHttpRequests((authorize) -> authorize
                .requestMatchers(
                        "/v3/api-docs/**",     // OpenAPI documentation endpoints
                        "/swagger-ui/**",      // Swagger UI static files
                        "/swagger-ui.html"// Main Swagger UI endpoint
                ).permitAll()
                .requestMatchers("/api/v1/accounts", "login").permitAll()
                .anyRequest().authenticated()
        )
        // Form login handles the redirect to the login page from the
        // authorization server filter chain
        .oauth2ResourceServer(oauth2 -> oauth2
            .jwt(jwt -> jwt
                .jwtAuthenticationConverter(jwtAuthenticationConverter())
            )
        )
        .formLogin(formConfig -> formConfig.loginPage("/login"))
        .logout(logout -> logout
            .logoutSuccessHandler((request, response, authentication) -> {
                String redirectUri = request.getParameter("post_logout_redirect_uri");
                if (redirectUri != null && !redirectUri.isEmpty()) {
                    response.sendRedirect(redirectUri);
                } else {
                    response.sendRedirect("/login?logout");
                }
            })
        )
        .exceptionHandling((exceptions) -> exceptions
            .defaultAuthenticationEntryPointFor(
                new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED),
                new AntPathRequestMatcher("/api/v1/**")
            )
        );
    return http.build();
  }

  @Bean
  public VMallJwtConverter jwtAuthenticationConverter() {
    return new VMallJwtConverter();
  }

  @Bean
  public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }
}
