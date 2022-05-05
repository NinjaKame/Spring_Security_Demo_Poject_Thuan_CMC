package com.thanos.SecurityDemo.security;

import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;

@Configuration
public class AlgorithmConfig {

    @Bean
    public Algorithm getMyAlgo(){
        return Algorithm.HMAC256("THANOS".getBytes(StandardCharsets.UTF_8));
    }
}
