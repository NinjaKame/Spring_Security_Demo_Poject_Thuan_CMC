package com.thanos.SecurityDemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class UserApp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Name", nullable = false)
    @NotNull
    private String name;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password", nullable = false)
    @NotNull
    private String password;

    @Column(name = "Role", nullable = false)
    @NotNull
    private String role;

    public UserApp(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
