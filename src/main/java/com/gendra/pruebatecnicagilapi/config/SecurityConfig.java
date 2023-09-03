package com.gendra.pruebatecnicagilapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Represents the security configuration of the application.
 * <p>
 * This configuration is essential for defining how different HTTP requests are
 * authenticated and authorized. It also contains settings to protect against
 * common vulnerabilities such as CSRF.
 * </p>
 *
 * @author Gilberto García
 * @version 1.0
 * @since 2023-09-03
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Configures the {@link HttpSecurity} to set authorization and security
     * settings.
     * <p>
     * In the current configuration:
     * <ul>
     * <li>CSRF protection is disabled.</li>
     * <li>All endpoints are open to everyone without any authentication.</li>
     * <li>Header frame options are disabled to allow H2 console.</li>
     * </ul>
     * </p>
     *
     * @param http the {@link HttpSecurity} to modify.
     * @throws Exception if there's an error during configuration.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                // Others Configurations
                .and()
                .headers().frameOptions().disable(); // Allow console H2
    }
}
