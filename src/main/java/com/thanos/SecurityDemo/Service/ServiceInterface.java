package com.thanos.SecurityDemo.Service;

import com.thanos.SecurityDemo.Entity.Customer;

import java.util.List;

public interface ServiceInterface {

    List<Customer> getAllCustomer();

    Customer getById(long id);

    Customer addCustomer(Customer cus);

    Customer updateCustomer(long id, Customer cus);

    void deleteCustomer(long id);


}
