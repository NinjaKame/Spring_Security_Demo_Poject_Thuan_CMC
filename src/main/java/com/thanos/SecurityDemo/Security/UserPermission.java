package com.thanos.SecurityDemo.Security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserPermission {
    CUSTOMER_READ("customer:read"),
    CUSTOMER_WRITE("customer:write"),
    ADMIN_READ("admin:read"),
    CLIENT_READ("client:read");

    private final String permission;

//    UserPermission(String permission) {
//        this.permission = permission;
//    }
}
