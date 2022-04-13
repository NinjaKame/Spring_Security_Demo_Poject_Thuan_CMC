package com.thanos.SecurityDemo.Security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum UserRole {
    ADMIN(Set.of(UserPermission.CUSTOMER_READ,
            UserPermission.CUSTOMER_WRITE,
            UserPermission.ADMIN_READ,
            UserPermission.CLIENT_READ)),

    CLIENT(Set.of(UserPermission.CUSTOMER_READ,
            UserPermission.CLIENT_READ)),

    CUSTOMER(new HashSet<>());

    private final Set<UserPermission> permissionSet;

    public Set<SimpleGrantedAuthority> getGrantedAuthority(){
        Set<SimpleGrantedAuthority> authorities = getPermissionSet().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());

//        Add ROLE_user to Authority Collection field for using in antMatchers.hasRole
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
