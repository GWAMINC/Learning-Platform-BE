package APIGateWay.APIGateWay.config;

import APIGateWay.APIGateWay.middleware.JwtAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebFluxSecurity
public class WebConfig {

    private static final Logger logger = LoggerFactory.getLogger(WebConfig.class);

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public WebConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        logger.info("🔍 [DEBUG] Cấu hình SecurityWebFilterChain...");

        http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .cors(corsSpec -> corsSpec.configurationSource(corsConfigurationSource()))
                .authorizeExchange(exchange -> exchange
                        .pathMatchers("/api/user/login").permitAll()
                        .pathMatchers("/api/user/register").permitAll()
                        .pathMatchers("/api/user/forgot-password").permitAll()
                        .pathMatchers("/api/payment/success").permitAll()
                        .pathMatchers("/api/payment/cancel").permitAll()
                        .anyExchange().authenticated()
                )
                .addFilterBefore(jwtAuthenticationFilter, SecurityWebFiltersOrder.AUTHENTICATION);

        logger.info("✅ [DEBUG] SecurityWebFilterChain đã cấu hình xong!");
        return http.build();
    }

    @Bean
    public UrlBasedCorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfig = new CorsConfiguration();

        corsConfig.setAllowedOrigins(Arrays.asList("http://localhost:5173")); // Cho phép FE gọi API
        corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Các phương thức HTTP được phép
        corsConfig.setAllowedHeaders(Arrays.asList("*")); // Cho phép tất cả header
        corsConfig.setAllowCredentials(true); // Quan trọng: Cho phép gửi Cookie JWT từ FE

        corsConfig.setExposedHeaders(Arrays.asList("Authorization", "Content-Type"));

        source.registerCorsConfiguration("/**", corsConfig);
        return source;
    }


}