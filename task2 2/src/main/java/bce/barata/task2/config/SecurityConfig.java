package bce.barata.task2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(HttpSecurity security) throws Exception
    {
        //security.httpBasic().disable(); // Did work only for GET
        security.csrf().disable().authorizeRequests().anyRequest().permitAll(); // Works for GET, POST, PUT, DELETE
        security.formLogin().disable();
        security.csrf().disable();
        security.headers().frameOptions().disable();
    }

    @Bean
    public PasswordEncoder encoder()
    {
        //return new StandardPasswordEncoder();
        return new BCryptPasswordEncoder();
    }




}
