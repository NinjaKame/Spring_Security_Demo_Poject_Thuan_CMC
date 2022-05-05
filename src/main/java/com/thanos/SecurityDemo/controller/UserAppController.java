package com.thanos.SecurityDemo.controller;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thanos.SecurityDemo.entity.UserApp;
import com.thanos.SecurityDemo.security.AlgorithmConfig;
import com.thanos.SecurityDemo.service.DaoUserAppService;
import com.thanos.SecurityDemo.service.UserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/")
public class UserAppController {

    private final UserAppService userAppService;
    private final DaoUserAppService daoUserAppService;

    @Autowired
    public UserAppController(UserAppService userAppService, DaoUserAppService daoUserAppService) {
        this.userAppService = userAppService;
        this.daoUserAppService = daoUserAppService;
    }

    @GetMapping("allUser")
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<List<UserApp>> getUserAppTable(){
        return new ResponseEntity<>(userAppService.getAllUserApp(), HttpStatus.OK);
    }

    @GetMapping("request/refreshToken")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                String refresh_token = authorizationHeader.substring("Bearer ".length());
                JWTVerifier jwtVerifier = JWT.require(new AlgorithmConfig().getMyAlgo()).build();
                DecodedJWT decodedJWT = jwtVerifier.verify(refresh_token);
                String username = decodedJWT.getSubject();
                UserDetails loadUser = daoUserAppService.loadUserByUsername(username);

                String new_access_token = JWT.create()
                        .withSubject(loadUser.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("authorities", loadUser.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                        .sign(new AlgorithmConfig().getMyAlgo());

                Map<String, String> tokens = new HashMap<>();
                tokens.put("new_access_token", new_access_token);
                tokens.put("refresh_token", refresh_token);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            } catch (Exception e) {
                response.setHeader("Error", e.getMessage());
                response.setStatus(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("Error_message", e.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        } else {
            throw new RuntimeException("Refresh token NOT found");
        }
    }
}
