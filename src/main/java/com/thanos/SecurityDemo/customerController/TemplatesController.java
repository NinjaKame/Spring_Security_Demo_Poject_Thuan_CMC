package com.thanos.SecurityDemo.customerController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TemplatesController {

    @GetMapping("admin")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adminPage(){
        System.out.println("Access admin page");
        return "adminPage";
    }

    @GetMapping("client")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CLIENT')")
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
    public String loginPage(){
        System.out.println("Access login page");
        return "myCustomLogin";
    }
}
