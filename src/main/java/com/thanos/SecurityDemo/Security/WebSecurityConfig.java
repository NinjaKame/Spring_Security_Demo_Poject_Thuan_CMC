package com.thanos.SecurityDemo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Autowired
//    public WebSecurityConfig(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/client").hasAnyRole("ADMIN","CLIENT")
                .antMatchers(HttpMethod.GET,"/allCus","/customerID/*").hasAnyRole("ADMIN","CLIENT")
                .antMatchers(HttpMethod.POST,"/addCus").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/updateCus/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/deleteCus/*").hasRole("ADMIN")

                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails adminUser = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("tht1"))
                .roles(UserRole.ADMIN.name())
                .build();

        UserDetails clientUser = User.builder()
                .username("client")
                .password(passwordEncoder.encode("tht2"))
                .roles(UserRole.CLIENT.name())
                .build();

        UserDetails customerUser = User.builder()
                .username("custom")
                .password(passwordEncoder.encode("tht3"))
                .roles(UserRole.CUSTOMER.name())
                .build();

        return new InMemoryUserDetailsManager(
                adminUser, clientUser, customerUser
        );
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
