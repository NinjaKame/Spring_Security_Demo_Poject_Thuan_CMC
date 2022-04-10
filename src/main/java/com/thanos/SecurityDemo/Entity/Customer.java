package com.thanos.SecurityDemo.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Email")
    private String email;

    @Column(name = "Age", nullable = false)
    private int age;

    public Customer(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
}
