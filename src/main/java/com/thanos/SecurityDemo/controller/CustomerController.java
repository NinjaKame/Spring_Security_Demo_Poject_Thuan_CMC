package com.thanos.SecurityDemo.controller;

import com.thanos.SecurityDemo.entity.Customer;
import com.thanos.SecurityDemo.entity.Product;
import com.thanos.SecurityDemo.service.CustomerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CustomerController {

    @Autowired
    private CustomerServiceInterface customerService;

    @GetMapping("allCus")
//    @PreAuthorize("hasAuthority('customer:read')")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
    }

    @GetMapping("allPro")
    public ResponseEntity<List<Product>> getAllProduct(){
        return new ResponseEntity<>(customerService.getAllProduct(), HttpStatus.OK);
    }

    @GetMapping("productID/{id}")
//    @PreAuthorize("hasAuthority('customer:read')")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        return new ResponseEntity<>(customerService.getProductById(id),HttpStatus.FOUND);
    }
    @GetMapping("customerID/{id}")
//    @PreAuthorize("hasAuthority('customer:read')")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id){
        return new ResponseEntity<>(customerService.getCustomerById(id),HttpStatus.FOUND);
    }

    @PostMapping("addCus")
//    @PreAuthorize("hasAuthority('customer:write')")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.addCustomer(customer),HttpStatus.CREATED);
    }

    @PutMapping("updateCus/{id}")
//    @PreAuthorize("hasAuthority('customer:write')")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer cus){
        return new ResponseEntity<>(customerService.updateCustomer(id, cus),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("deleteCus/{id}")
//    @PreAuthorize("hasAuthority('customer:write')")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
