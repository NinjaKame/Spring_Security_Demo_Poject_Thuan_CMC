package com.thanos.SecurityDemo.Controller;

import com.thanos.SecurityDemo.Entity.Customer;
import com.thanos.SecurityDemo.Service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping
public class Controller {

    @Autowired
    private ServiceInterface serviceInterface;

    @GetMapping("/admin")
    public String adminPage(){
        System.out.println("Access admin page");
        return "adminPage";
    }

    @GetMapping("/client")
    public String clientPage(){
        System.out.println("Access client page");
        return "clientPage";
    }

    @GetMapping("/cus")
    public String cusPage(){
        System.out.println("Access customer page");
        return "customerPage";
    }

    @GetMapping("/allCus")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        return new ResponseEntity<>(serviceInterface.getAllCustomer(), HttpStatus.OK);
    }

    @PostMapping("/addCus")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(serviceInterface.addCustomer(customer),HttpStatus.CREATED);
    }

    @GetMapping("/customer/ID/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable long id){
        return new ResponseEntity<>(serviceInterface.getById(id),HttpStatus.FOUND);
    }

    @PutMapping("/updateCus/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable long id, @RequestBody Customer cus){
        return new ResponseEntity<>(serviceInterface.updateCustomer(id, cus),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteCus/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable long id){
        serviceInterface.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
