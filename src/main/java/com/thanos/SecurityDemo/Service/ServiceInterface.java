package com.thanos.SecurityDemo.Service;

import com.thanos.SecurityDemo.Entity.Customer;

import java.util.List;

public interface ServiceInterface {

    List<Customer> getAllCustomer();

    Customer getById(int id);

    Customer addCustomer(Customer cus);

    Customer updateCustomer(int id, Customer cus);

    void deleteCustomer(int id);

}
