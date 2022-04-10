package com.thanos.SecurityDemo.Service;

import com.thanos.SecurityDemo.Entity.Customer;
import com.thanos.SecurityDemo.Repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMessage;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceImpl implements ServiceInterface, CommandLineRunner {

    @Autowired
    private Repo repository;

    @Override
    public List<Customer> getAllCustomer() {
        return repository.findAll();
    }

    @Override
    public Customer getById(long id) {
        return repository.getById(id);
    }

    @Override
    public Customer addCustomer(Customer cus) {
        return repository.save(cus);
    }

    @Override
    public Customer updateCustomer(long id, Customer updateCus) {
        Customer oldCustomer = repository.getById(id);
        oldCustomer.setName(updateCus.getName()).setEmail(updateCus.getEmail()).setAge(updateCus.getAge());
        return repository.save(oldCustomer);
    }

    @Override
    public void deleteCustomer(long id) {
        repository.delete(repository.getById(id));
    }


    @Override
    public void run(String... args) throws Exception {

        List<Customer> customerList = Arrays.asList(
                new Customer("John Cena", "Cena@gmail.com", 23),
                new Customer("Phong Tom", "PhongTom@gmail.com", 99),
                new Customer("Binh Ty", "BinhTy@gmail.com", 96),
                new Customer("Cong Phuong", "CongPhuong@gmail.com", 27),
                new Customer("Lionel Messi", "Messi@gmail.com", 10),
                new Customer("Kento Momota", "Momota@gmail.com", 30)
        );
        repository.saveAll(customerList);
    }
}
