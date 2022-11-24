package mirea.example.learningenglishmanagementsystem.config;

import lombok.AllArgsConstructor;
import mirea.example.learningenglishmanagementsystem.services.JpaUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests((requests) -> requests
                        .mvcMatchers("/admin/**").hasRole("ADMIN")
                        .mvcMatchers("/user/**", "/error").permitAll()
                        .anyRequest().hasAnyRole("USER", "ADMIN")).
                formLogin((form) -> form
                    .loginPage("/user/login")
                        .usernameParameter("login")
                        .passwordParameter("password")
                    .loginProcessingUrl("/login") // Передаст authProvider username and password и спринг сам проверит с помощью userDetails корректность.
                    .defaultSuccessUrl("/simple-english/home", true)
                    .failureUrl("/user/login?error"))

                    .logout((logout) -> logout.logoutSuccessUrl("/login"));

        return http.build();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}