package com.thanos.SecurityDemo.repository;

import com.thanos.SecurityDemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {
}
