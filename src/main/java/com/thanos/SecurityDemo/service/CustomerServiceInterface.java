package com.thanos.SecurityDemo.service;

import com.thanos.SecurityDemo.entity.Customer;
import com.thanos.SecurityDemo.entity.Product;

import java.util.List;

public interface CustomerServiceInterface {

    List<Customer> getAllCustomer();

    List<Product> getAllProduct();

    Product getProductById(long id);

    Customer getCustomerById(int id);

    Customer addCustomer(Customer cus);

    Customer updateCustomer(int id, Customer cus);

    void deleteCustomer(int id);

}
