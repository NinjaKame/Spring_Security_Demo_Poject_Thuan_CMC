package com.thanos.SecurityDemo.customerRepository;

import com.thanos.SecurityDemo.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepo extends JpaRepository<Customer,Integer> {
}
