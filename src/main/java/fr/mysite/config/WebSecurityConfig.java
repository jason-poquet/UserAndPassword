package fr.mysite.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * Configure the http security
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
           http.csrf().disable().authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers(HttpMethod.GET,"/api/user/*").permitAll()
            .antMatchers(HttpMethod.POST,"/api/user/*").permitAll()
            .antMatchers(HttpMethod.GET,"/api/compliance/*").permitAll()
            .antMatchers(HttpMethod.POST,"/api/compliance/*").permitAll()
            .anyRequest().permitAll();
    }
    
    /**
     * Configure the {@link CorsConfigurationSource} Bean
     * 
     * @return the {@link CorsConfigurationSource}
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token"));
        configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        
        return source;
    }


}
