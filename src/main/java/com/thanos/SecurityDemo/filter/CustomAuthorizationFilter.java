package com.thanos.SecurityDemo.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thanos.SecurityDemo.Security.AlgorithmConfig;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class CustomAuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        if ((request.getServletPath().equals("/login"))){
//            filterChain.doFilter(request,response);
//        } else {
            String authorizationHeader = request.getHeader(AUTHORIZATION);
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
                try {
                    String userToken = authorizationHeader.substring("Bearer ".length());
                    JWTVerifier jwtVerifier = JWT.require(new AlgorithmConfig().getMyAlgo()).build();
                    DecodedJWT decodedJWT = jwtVerifier.verify(userToken);
                    String username = decodedJWT.getSubject();
                    String[] authorities = decodedJWT.getClaim("authorities").asArray(String.class);
                    Collection<SimpleGrantedAuthority> authorityCollection =
                            Arrays.stream(authorities)
                                    .map(SimpleGrantedAuthority::new)
                                    .collect(Collectors.toSet());
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(username,null,authorityCollection);
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    filterChain.doFilter(request,response);
                } catch (Exception e){
                    response.setHeader("Error",e.getMessage());
                    response.setStatus(FORBIDDEN.value());
//                    response.sendError(FORBIDDEN.value());
                    Map<String,String> error = new HashMap<>();
                    error.put("Error_message",e.getMessage());
                    response.setContentType(APPLICATION_JSON_VALUE);
                    new ObjectMapper().writeValue(response.getOutputStream(),error);
                }
            } else {
                filterChain.doFilter(request,response);
            }
        }
//    }

}
