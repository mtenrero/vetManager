package es.urjc.etsii.mtenrero;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by marcostenrero on 5/3/17.
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    static final String MANAGER = "MANAGER";
    static final String CLIENT = "CLIENT";


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // Login form configuration
        http.formLogin().loginPage("/");
        http.formLogin().usernameParameter("id");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/dashboard/");
        http.formLogin().failureUrl("/");

        // Public routes
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/resources/**").permitAll();

        // Dashboard access (Veterinary management)
        http.authorizeRequests().antMatchers("/dashboard/**").hasAnyRole(MANAGER);

        // Disable CSRF by the moment
        http.csrf().disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // Users
        auth.inMemoryAuthentication().withUser("999").password("vetmanager") .roles("MANAGER");
        auth.inMemoryAuthentication().withUser("1234").password("cliente") .roles("CLIENTE");

    }
}
