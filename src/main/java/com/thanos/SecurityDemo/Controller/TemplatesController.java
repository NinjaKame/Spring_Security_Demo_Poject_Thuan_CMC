package com.thanos.SecurityDemo.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TemplatesController {

    @GetMapping("admin")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PreAuthorize("hasAuthority('admin:read')")
    public String adminPage(){
        System.out.println("Access admin page");
        return "adminPage";
    }

    @GetMapping("client")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CLIENT')")
    @PreAuthorize("hasAuthority('client:read')")
    public String clientPage(){
        System.out.println("Access client page");
        return "clientPage";
    }

    @GetMapping("cus")
    public String cusPage(){
        System.out.println("Access customer page");
        return "customerPage";
    }

    @GetMapping("login")
    public String getLoginPage(){
        return "login";
    }
}
