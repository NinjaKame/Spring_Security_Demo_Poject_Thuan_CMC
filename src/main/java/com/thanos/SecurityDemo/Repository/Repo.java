package com.thanos.SecurityDemo.Repository;

import com.thanos.SecurityDemo.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface Repo extends JpaRepository<Customer, Integer> {
}
