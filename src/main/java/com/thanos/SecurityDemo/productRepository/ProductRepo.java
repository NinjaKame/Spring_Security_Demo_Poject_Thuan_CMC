package com.thanos.SecurityDemo.productRepository;

import com.thanos.SecurityDemo.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {
}
