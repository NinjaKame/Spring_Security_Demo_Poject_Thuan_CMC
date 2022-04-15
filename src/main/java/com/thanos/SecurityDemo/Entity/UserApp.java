package com.thanos.SecurityDemo.Entity;

import com.thanos.SecurityDemo.Security.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
    private String name;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "Role", nullable = false)
    private String role;

    public UserApp(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
