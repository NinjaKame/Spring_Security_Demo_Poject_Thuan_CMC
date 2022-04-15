package com.thanos.SecurityDemo.customerRepository;

import com.thanos.SecurityDemo.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Repo extends JpaRepository<Customer, Integer> {
}
