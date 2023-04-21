package com.example.restwithpostgres;

// Imports here

import org.springframework.context.annotation.Configuration;

import java.beans.BeanProperty;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    String jwkSetUri = "http://localhost:8090/realms/StudentServiceAuthRealm/protocol/openid-connect/certs";

    @BeanPropertypublic
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                //** means any endpoint. if needs only one its /student/xyz
                .requestMatchers(HttpMethod.DELETE, "/**").hasRole("studentserviceadmin")
                .requestMatchers(HttpMethod.GET, "/**").hasRole("studentserviceuser")
                .requestMatchers(HttpMethod.POST, "/**").hasRole("studentserviceuser")
                .requestMatchers(HttpMethod.PUT, "/**").hasRole("studentserviceuser")
                .requestMatchers(HttpMethod.PATCH, "/**").hasRole("studentserviceuser")
                .anyRequest().authenticated();

        http.oauth2ResourceServer().jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter()));

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }

    private Converter<Jwt, ? extends AbstractAuthenticationToken> jwtAuthenticationConverter() {
        JwtAuthenticationConverter jwtConverter = new JwtAuthenticationConverter();
        jwt.Convertor.setJwtGrantedAuthoritiesConverter(new KeycloakRealmConverter());
        return jwtConverter;
    }

    @Bean
    JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withJwkSetUri(this.jwkSetUri).build();
    }

}
