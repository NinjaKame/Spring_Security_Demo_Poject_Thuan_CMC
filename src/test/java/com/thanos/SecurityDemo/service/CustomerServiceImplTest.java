package com.thanos.SecurityDemo.service;

import com.thanos.SecurityDemo.entity.Customer;
import com.thanos.SecurityDemo.entity.Product;
import com.thanos.SecurityDemo.repository.CustomerRepo;
import com.thanos.SecurityDemo.repository.ProductRepo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {CustomerServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CustomerServiceImplTest {

    @MockBean
    private CustomerRepo customerRepo;

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @MockBean
    private ProductRepo productRepo;

    /**
     * Method under test: {@link CustomerServiceImpl#getAllCustomer()}
     */
    @Test
    void testGetAllCustomer() {
        ArrayList<Customer> customerList = new ArrayList<>();
        when(this.customerRepo.findAll()).thenReturn(customerList);
        List<Customer> actualAllCustomer = this.customerServiceImpl.getAllCustomer();
        assertSame(customerList, actualAllCustomer);
        assertTrue(actualAllCustomer.isEmpty());
        verify(this.customerRepo).findAll();
    }

    /**
     * Method under test: {@link CustomerServiceImpl#getAllCustomer()}
     */
    @Test
    void testGetAllCustomer2() {
        when(this.customerRepo.findAll()).thenThrow(new NoSuchElementException("foo"));
        assertThrows(NoSuchElementException.class, () -> this.customerServiceImpl.getAllCustomer());
        verify(this.customerRepo).findAll();
    }

    /**
     * Method under test: {@link CustomerServiceImpl#getAllProduct()}
     */
    @Test
    void testGetAllProduct() {
        ArrayList<Product> productList = new ArrayList<>();
        when(this.productRepo.findAll()).thenReturn(productList);
        List<Product> actualAllProduct = this.customerServiceImpl.getAllProduct();
        assertSame(productList, actualAllProduct);
        assertTrue(actualAllProduct.isEmpty());
        verify(this.productRepo).findAll();
    }

    /**
     * Method under test: {@link CustomerServiceImpl#getAllProduct()}
     */
    @Test
    void testGetAllProduct2() {
        when(this.productRepo.findAll()).thenThrow(new NoSuchElementException("foo"));
        assertThrows(NoSuchElementException.class, () -> this.customerServiceImpl.getAllProduct());
        verify(this.productRepo).findAll();
    }

    /**
     * Method under test: {@link CustomerServiceImpl#getProductById(long)}
     */
    @Test
    void testGetProductById() {
        Product product = new Product();
        product.setCustomers(new HashSet<>());
        product.setId(123L);
        product.setName("Name");
        Optional<Product> ofResult = Optional.of(product);
        when(this.productRepo.findById((Long) any())).thenReturn(ofResult);
        assertSame(product, this.customerServiceImpl.getProductById(123L));
        verify(this.productRepo).findById((Long) any());
    }

    /**
     * Method under test: {@link CustomerServiceImpl#getProductById(long)}
     */
    @Test
    void testGetProductById2() {
        when(this.productRepo.findById((Long) any())).thenReturn(Optional.empty());
        assertThrows(NoSuchElementException.class, () -> this.customerServiceImpl.getProductById(123L));
        verify(this.productRepo).findById((Long) any());
    }

    /**
     * Method under test: {@link CustomerServiceImpl#getProductById(long)}
     */
    @Test
    void testGetProductById3() {
        when(this.productRepo.findById((Long) any())).thenThrow(new NoSuchElementException("foo"));
        assertThrows(NoSuchElementException.class, () -> this.customerServiceImpl.getProductById(123L));
        verify(this.productRepo).findById((Long) any());
    }

    /**
     * Method under test: {@link CustomerServiceImpl#getCustomerById(int)}
     */
    @Test
    void testGetCustomerById() {
        Customer customer = new Customer();
        customer.setAge(1);
        customer.setEmail("jane.doe@example.org");
        customer.setId(1);
        customer.setName("Name");
        customer.setProductList(new ArrayList<>());
        Optional<Customer> ofResult = Optional.of(customer);
        when(this.customerRepo.findById((Integer) any())).thenReturn(ofResult);
        assertSame(customer, this.customerServiceImpl.getCustomerById(1));
        verify(this.customerRepo).findById((Integer) any());
    }

    /**
     * Method under test: {@link CustomerServiceImpl#getCustomerById(int)}
     */
    @Test
    void testGetCustomerById2() {
        when(this.customerRepo.findById((Integer) any())).thenReturn(Optional.empty());
        assertThrows(NoSuchElementException.class, () -> this.customerServiceImpl.getCustomerById(1));
        verify(this.customerRepo).findById((Integer) any());
    }

    /**
     * Method under test: {@link CustomerServiceImpl#getCustomerById(int)}
     */
    @Test
    void testGetCustomerById3() {
        when(this.customerRepo.findById((Integer) any())).thenThrow(new NoSuchElementException("foo"));
        assertThrows(NoSuchElementException.class, () -> this.customerServiceImpl.getCustomerById(1));
        verify(this.customerRepo).findById((Integer) any());
    }

    @BeforeEach
    void setUp() {
    }

    @Test
    void getAllCustomer() {
    }

    @Test
    void getAllProduct() {
    }

    @Test
    void getProductById() {
    }

    @Test
    void getCustomerById() {
    }

    @Test
    void addCustomer() {
    }

    @Test
    void updateCustomer() {
    }

    @Test
    void deleteCustomer() {
    }

    /**
     * Method under test: {@link CustomerServiceImpl#addCustomer(Customer)}
     */
    @Test
    void testAddCustomer() {
        Customer customer = new Customer();
        customer.setAge(1);
        customer.setEmail("jane.doe@example.org");
        customer.setId(1);
        customer.setName("Name");
        customer.setProductList(new ArrayList<>());
        when(this.customerRepo.save((Customer) any())).thenReturn(customer);

        Customer customer1 = new Customer();
        customer1.setAge(1);
        customer1.setEmail("jane.doe@example.org");
        customer1.setId(1);
        customer1.setName("Name");
        customer1.setProductList(new ArrayList<>());
        assertSame(customer, this.customerServiceImpl.addCustomer(customer1));
        verify(this.customerRepo).save((Customer) any());
    }

    /**
     * Method under test: {@link CustomerServiceImpl#addCustomer(Customer)}
     */
    @Test
    void testAddCustomer2() {
        when(this.customerRepo.save((Customer) any())).thenThrow(new NoSuchElementException("foo"));

        Customer customer = new Customer();
        customer.setAge(1);
        customer.setEmail("jane.doe@example.org");
        customer.setId(1);
        customer.setName("Name");
        customer.setProductList(new ArrayList<>());
        assertThrows(NoSuchElementException.class, () -> this.customerServiceImpl.addCustomer(customer));
        verify(this.customerRepo).save((Customer) any());
    }

    /**
     * Method under test: {@link CustomerServiceImpl#updateCustomer(int, Customer)}
     */
    @Test
    void testUpdateCustomer() {
        Customer customer = new Customer();
        customer.setAge(1);
        customer.setEmail("jane.doe@example.org");
        customer.setId(1);
        customer.setName("Name");
        customer.setProductList(new ArrayList<>());

        Customer customer1 = new Customer();
        customer1.setAge(1);
        customer1.setEmail("jane.doe@example.org");
        customer1.setId(1);
        customer1.setName("Name");
        customer1.setProductList(new ArrayList<>());
        when(this.customerRepo.save((Customer) any())).thenReturn(customer1);
        when(this.customerRepo.getById((Integer) any())).thenReturn(customer);

        Customer customer2 = new Customer();
        customer2.setAge(1);
        customer2.setEmail("jane.doe@example.org");
        customer2.setId(1);
        customer2.setName("Name");
        customer2.setProductList(new ArrayList<>());
        assertSame(customer1, this.customerServiceImpl.updateCustomer(1, customer2));
        verify(this.customerRepo).getById((Integer) any());
        verify(this.customerRepo).save((Customer) any());
    }

    /**
     * Method under test: {@link CustomerServiceImpl#updateCustomer(int, Customer)}
     */
    @Test
    void testUpdateCustomer2() {
        Customer customer = new Customer();
        customer.setAge(1);
        customer.setEmail("jane.doe@example.org");
        customer.setId(1);
        customer.setName("Name");
        customer.setProductList(new ArrayList<>());
        when(this.customerRepo.save((Customer) any())).thenThrow(new NoSuchElementException("foo"));
        when(this.customerRepo.getById((Integer) any())).thenReturn(customer);

        Customer customer1 = new Customer();
        customer1.setAge(1);
        customer1.setEmail("jane.doe@example.org");
        customer1.setId(1);
        customer1.setName("Name");
        customer1.setProductList(new ArrayList<>());
        assertThrows(NoSuchElementException.class, () -> this.customerServiceImpl.updateCustomer(1, customer1));
        verify(this.customerRepo).getById((Integer) any());
        verify(this.customerRepo).save((Customer) any());
    }

    /**
     * Method under test: {@link CustomerServiceImpl#deleteCustomer(int)}
     */
    @Test
    void testDeleteCustomer() {
        doNothing().when(this.customerRepo).deleteById((Integer) any());
        this.customerServiceImpl.deleteCustomer(1);
        verify(this.customerRepo).deleteById((Integer) any());
        assertTrue(this.customerServiceImpl.getAllCustomer().isEmpty());
        assertTrue(this.customerServiceImpl.getAllProduct().isEmpty());
    }

    /**
     * Method under test: {@link CustomerServiceImpl#deleteCustomer(int)}
     */
    @Test
    void testDeleteCustomer2() {
        doThrow(new NoSuchElementException("foo")).when(this.customerRepo).deleteById((Integer) any());
        assertThrows(NoSuchElementException.class, () -> this.customerServiceImpl.deleteCustomer(1));
        verify(this.customerRepo).deleteById((Integer) any());
    }

    /**
     * Method under test: {@link CustomerServiceImpl#run(String[])}
     */
    @Test
    void testRun() {
        when(this.productRepo.findAll()).thenReturn(new ArrayList<>());
        when(this.productRepo.saveAll((Iterable<Product>) any())).thenReturn(new ArrayList<>());
        when(this.customerRepo.saveAll((Iterable<Customer>) any())).thenReturn(new ArrayList<>());
        this.customerServiceImpl.run("Args");
        verify(this.productRepo, atLeast(1)).findAll();
        verify(this.productRepo).saveAll((Iterable<Product>) any());
        verify(this.customerRepo).saveAll((Iterable<Customer>) any());
    }

    /**
     * Method under test: {@link CustomerServiceImpl#run(String[])}
     */
    @Test
    void testRun2() {
        when(this.productRepo.findAll()).thenReturn(new ArrayList<>());
        when(this.productRepo.saveAll((Iterable<Product>) any())).thenReturn(new ArrayList<>());
        when(this.customerRepo.saveAll((Iterable<Customer>) any())).thenThrow(new NoSuchElementException("John Cena"));
        assertThrows(NoSuchElementException.class, () -> this.customerServiceImpl.run("Args"));
        verify(this.productRepo, atLeast(1)).findAll();
        verify(this.productRepo).saveAll((Iterable<Product>) any());
        verify(this.customerRepo).saveAll((Iterable<Customer>) any());
    }

    /**
     * Method under test: {@link CustomerServiceImpl#run(String[])}
     */
    @Test
    void testRun3() {
        Product product = new Product();
        product.setCustomers(new HashSet<>());
        product.setId(123L);
        product.setName("John Cena");

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product);
        when(this.productRepo.findAll()).thenReturn(productList);
        when(this.productRepo.saveAll((Iterable<Product>) any())).thenReturn(new ArrayList<>());
        when(this.customerRepo.saveAll((Iterable<Customer>) any())).thenReturn(new ArrayList<>());
        this.customerServiceImpl.run("Args");
        verify(this.productRepo, atLeast(1)).findAll();
        verify(this.productRepo).saveAll((Iterable<Product>) any());
        verify(this.customerRepo).saveAll((Iterable<Customer>) any());
    }

    /**
     * Method under test: {@link CustomerServiceImpl#run(String[])}
     */
    @Test
    void testRun4() {
        Product product = new Product();
        product.setCustomers(new HashSet<>());
        product.setId(123L);
        product.setName("John Cena");

        Product product1 = new Product();
        product1.setCustomers(new HashSet<>());
        product1.setId(123L);
        product1.setName("John Cena");

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product);
        when(this.productRepo.findAll()).thenReturn(productList);
        when(this.productRepo.saveAll((Iterable<Product>) any())).thenReturn(new ArrayList<>());
        when(this.customerRepo.saveAll((Iterable<Customer>) any())).thenReturn(new ArrayList<>());
        this.customerServiceImpl.run("Args");
        verify(this.productRepo, atLeast(1)).findAll();
        verify(this.productRepo).saveAll((Iterable<Product>) any());
        verify(this.customerRepo).saveAll((Iterable<Customer>) any());
    }

    /**
     * Method under test: {@link CustomerServiceImpl#run(String[])}
     */
    @Test
    void testRun5() {
        Product product = mock(Product.class);
        when(product.getName()).thenReturn("Name");
        doNothing().when(product).setCustomers((java.util.Set<Customer>) any());
        doNothing().when(product).setId((Long) any());
        doNothing().when(product).setName((String) any());
        product.setCustomers(new HashSet<>());
        product.setId(123L);
        product.setName("John Cena");

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product);
        when(this.productRepo.findAll()).thenReturn(productList);
        when(this.productRepo.saveAll((Iterable<Product>) any())).thenReturn(new ArrayList<>());
        when(this.customerRepo.saveAll((Iterable<Customer>) any())).thenReturn(new ArrayList<>());
        this.customerServiceImpl.run("Args");
        verify(this.productRepo, atLeast(1)).findAll();
        verify(this.productRepo).saveAll((Iterable<Product>) any());
        verify(product, atLeast(1)).getName();
        verify(product).setCustomers((java.util.Set<Customer>) any());
        verify(product).setId((Long) any());
        verify(product).setName((String) any());
        verify(this.customerRepo).saveAll((Iterable<Customer>) any());
    }
}