package villar.financial.financialcontrol.infrastructure.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfigurationSource;
import villar.financial.financialcontrol.infrastructure.security.handler.CustomAccessDeniedHandler;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final SecurityFilter securityFilter;
    private final CorsConfigurationSource corsConfigurationSource;

    @Bean
    @ConditionalOnMissingBean(SecurityFilterChain.class)
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests(
                        authorize -> {
                            authorize.requestMatchers(PathRequest.toH2Console()).permitAll();
                            authorize.requestMatchers(
                                    "/signin",
                                    "/account",
                                    "/account/**",
                                    "/actuator/**",
                                    "/v3/api-docs/**",
                                    "/swagger-ui/**",
                                    "/swagger-ui.html"
                            ).permitAll();

                            authorize.requestMatchers(
                                            "/budget",
                                            "/category",
                                            "/goal",
                                            "/product",
                                            "/wallet"
                                    ).hasAnyRole("USER")
                                    .anyRequest().authenticated();
                        }
                )


                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint())

                .and().cors().configurationSource(corsConfigurationSource)

                .and()
                .headers().frameOptions().sameOrigin()

                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and().addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new CustomAccessDeniedHandler(new ObjectMapper());
    }

}
