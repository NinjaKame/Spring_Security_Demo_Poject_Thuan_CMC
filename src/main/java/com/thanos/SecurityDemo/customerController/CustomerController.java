package com.thanos.SecurityDemo.customerController;

import com.thanos.SecurityDemo.Entity.Customer;
import com.thanos.SecurityDemo.Entity.Product;
import com.thanos.SecurityDemo.customerService.ServiceInterface;
import com.thanos.SecurityDemo.productRepository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CustomerController {

    @Autowired
    private ServiceInterface serviceInterface;
    @Autowired
    private ProductRepo productRepo;

    @GetMapping("allCus")
//    @PreAuthorize("hasAuthority('customer:read')")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        return new ResponseEntity<>(serviceInterface.getAllCustomer(), HttpStatus.OK);
    }

    @GetMapping("allPro")
//    @PreAuthorize("hasAuthority('customer:read')")
    public ResponseEntity<List<Product>> getAllProduct(){
        return new ResponseEntity<>(productRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping("customerID/{id}")
//    @PreAuthorize("hasAuthority('customer:read')")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id){
        return new ResponseEntity<>(serviceInterface.getById(id),HttpStatus.FOUND);
    }

    @PostMapping("addCus")
//    @PreAuthorize("hasAuthority('customer:write')")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(serviceInterface.addCustomer(customer),HttpStatus.CREATED);
    }

    @PutMapping("updateCus/{id}")
//    @PreAuthorize("hasAuthority('customer:write')")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer cus){
        return new ResponseEntity<>(serviceInterface.updateCustomer(id, cus),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("deleteCus/{id}")
//    @PreAuthorize("hasAuthority('customer:write')")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int id){
        serviceInterface.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
