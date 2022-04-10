package com.thanos.SecurityDemo.Repository;

import com.thanos.SecurityDemo.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Repo extends JpaRepository<Customer,Long> {
}
