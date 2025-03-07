package APIGateWay.APIGateWay.middleware;

import APIGateWay.APIGateWay.utils.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class JwtAuthenticationFilter implements WebFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    private final JwtUtil jwtUtil;

    public JwtAuthenticationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        if (request.getPath().toString().equals("/api/user/login")) {
            return chain.filter(exchange);
        }

        if (request.getPath().toString().equals("/api/user/register")) {
            return chain.filter(exchange);
        }

        if (request.getPath().toString().equals("/api/user/forgot-password")) {
            return chain.filter(exchange);
        }
        if (request.getPath().toString().equals("/api/payment/success")) {
            return chain.filter(exchange);
        }
        if (request.getPath().toString().equals("/api/payment/cancel")) {
            return chain.filter(exchange);
        }


        String authorizationHeader = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        System.out.println("📢 Authorization Header: " + authorizationHeader);
    
        String token = null;
        HttpCookie jwtCookie = request.getCookies().getFirst("token");
        if (jwtCookie != null) {
            token = jwtCookie.getValue();
        }

//        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
//            return unauthorizedResponse(exchange);
//        }
        if (token == null) {
            return unauthorizedResponse(exchange);
        }

//        String token = authorizationHeader.substring(7);
        System.out.println("📢 Token Extracted: " + token);
        String email = jwtUtil.extractEmail(token);

        if (email == null || !jwtUtil.validateToken(token, email)) {
            return unauthorizedResponse(exchange);
        }
        // Thêm Authentication vào SecurityContext
        UserDetails userDetails = User.withUsername(email).password("").roles("USER").build();
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

        SecurityContext securityContext = new SecurityContextImpl(authentication);

        System.out.println("✅ Security Context Updated for User: " + email);

        return chain.filter(exchange)
                .contextWrite(ReactiveSecurityContextHolder.withSecurityContext(Mono.just(securityContext)));
    }

    private Mono<Void> unauthorizedResponse(ServerWebExchange exchange) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        return response.setComplete();
    }
}