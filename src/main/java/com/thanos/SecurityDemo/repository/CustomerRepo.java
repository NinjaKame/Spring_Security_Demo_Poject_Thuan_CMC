package com.thanos.SecurityDemo.repository;

import com.thanos.SecurityDemo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepo extends JpaRepository<Customer,Integer> {
}
