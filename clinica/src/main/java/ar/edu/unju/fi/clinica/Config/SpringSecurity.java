/**
 * 
 */
package ar.edu.unju.fi.clinica.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @author Diaz, Sebastián Darío
 * Clase de configuración de Spring Security.
 */
@Configuration
@EnableWebSecurity
public class SpringSecurity {

	/*private static final String[] AUTH_WHITE_LIST = {
            "/api/v2/api-docs/**",
            "/swagger-ui/**",
            "/api/v1/api-docs/**",
            "/swagger-resources/**"
    };*/
	
	/**
	 * Factory Method para instanciar el encoder.
	 * @return instancia de BcryptPasswordEncoder.
	 */
	@Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

	/**
	 * Factory Method para configurar la entidad http y las url utilizadas.
	 */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                //.antMatchers(AUTH_WHITE_LIST).permitAll()
                .antMatchers("/register/**").permitAll()
                .antMatchers("/index").permitAll()
                .antMatchers("/users/**").hasRole("ADMINISTRATOR")
                .antMatchers("/meets/**","/patient/**","/doctor/**").hasRole("OPERATOR")
                .and()
                .formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/default")
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()

                );
        return http.build();
    }
}
