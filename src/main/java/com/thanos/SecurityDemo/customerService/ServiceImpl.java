package com.thanos.SecurityDemo.customerService;

import com.thanos.SecurityDemo.Entity.Customer;
import com.thanos.SecurityDemo.Entity.Product;
import com.thanos.SecurityDemo.customerRepository.CustomerRepo;
import com.thanos.SecurityDemo.productRepository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ServiceImpl implements ServiceInterface, CommandLineRunner {

    @Autowired
    private CustomerRepo cusRepository;

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Customer> getAllCustomer() {
        return cusRepository.findAll();
    }

    @Override
    public Customer getById(int id) {
        Optional<Customer> result = cusRepository.findById(id);
        if (result.isPresent()){
            return result.get();
        } else {
            throw new  NoSuchElementException("Customer ID: " +id+ " NOT found. Please try again");
        }
    }

    @Override
    public Customer addCustomer(Customer cus) {
        return cusRepository.save(cus);
    }

    @Override
    public Customer updateCustomer(int id, Customer updateCus) {
        Customer oldCustomer = cusRepository.getById(id);
        oldCustomer.setName(updateCus.getName()).setEmail(updateCus.getEmail()).setAge(updateCus.getAge());
        return cusRepository.save(oldCustomer);
    }

    @Override
    public void deleteCustomer(int id) {
        cusRepository.deleteById(id);
    }


    @Override
    public void run(String... args) {
        List<Customer> customerList = Arrays.asList(
                new Customer("John Cena", "Cena@gmail.com", 23),
                new Customer("Phong Tom", "PhongTom@gmail.com", 99),
                new Customer("Binh Ty", "BinhTy@gmail.com", 96),
                new Customer("Lionel Messi", "Messi@gmail.com", 10),
                new Customer("Kento Momota", "Momota@gmail.com", 30)
        );

        List<Product> productList = Arrays.asList(
                new Product("Sport Bike"),
                new Product("Super Car"),
                new Product("Iphone"),
                new Product("Ipad"),
                new Product("Ipod"),
                new Product("MacBook")
        );
        productRepo.saveAll(productList);
        List<Product> list1 = productRepo.findAll().stream().filter(product -> product.getName().length()>=7).collect(Collectors.toList());
        List<Product> list2 = productRepo.findAll().stream().filter(product -> product.getName().startsWith("I")).collect(Collectors.toList());
        List<Product> list3 = productRepo.findAll().stream().filter(product -> product.getName().startsWith("S")).collect(Collectors.toList());
        List<Product> list4 = productRepo.findAll().stream().filter(product -> product.getName().contains("o")).collect(Collectors.toList());
        List<Product> list5 = productRepo.findAll().stream().filter(product -> product.getName().contains("a")).collect(Collectors.toList());
        customerList.get(0).setProductList(list1);
        customerList.get(1).setProductList(list2);
        customerList.get(2).setProductList(list3);
        customerList.get(3).setProductList(list4);
        customerList.get(4).setProductList(list5);

        cusRepository.saveAll(customerList);
    }
}
