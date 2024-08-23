package ru.yulialyapushkina.library_project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.yulialyapushkina.library_project.entities.RoleType;
import ru.yulialyapushkina.library_project.security.UserDetailsServiceImpl;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {
    private final UserDetailsServiceImpl userDetailsService;
   // private  final UserDetailsImpl userDetails;

    @Autowired
    public SecurityConfiguration(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;

    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() throws Exception {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);

        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
           return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        httpSecurity.authenticationProvider(authenticationProvider());
        httpSecurity.authorizeHttpRequests((autorisation)->autorisation
                .requestMatchers("/book/v2/**").hasAnyAuthority(RoleType.USER.name(), RoleType.ADMIN.name())
                .requestMatchers("/books").hasAnyAuthority(RoleType.ADMIN.name())

                .anyRequest().authenticated())
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll);
        httpSecurity.exceptionHandling(Customizer.withDefaults());
return httpSecurity.build();
    }
}
