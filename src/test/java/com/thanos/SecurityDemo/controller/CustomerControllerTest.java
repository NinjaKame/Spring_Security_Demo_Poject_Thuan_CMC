package com.thanos.SecurityDemo.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.thanos.SecurityDemo.entity.Customer;
import com.thanos.SecurityDemo.entity.Product;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class CustomerControllerTest {
    /**
     * Method under test: {@link CustomerController#getAllCustomer()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllCustomer() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.thanos.SecurityDemo.controller.CustomerController.getAllCustomer(CustomerController.java:23)
        //   In order to prevent getAllCustomer()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAllCustomer().
        //   See https://diff.blue/R013 to resolve this issue.

        (new CustomerController()).getAllCustomer();
    }

    /**
     * Method under test: {@link CustomerController#getAllProduct()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllProduct() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.thanos.SecurityDemo.controller.CustomerController.getAllProduct(CustomerController.java:28)
        //   In order to prevent getAllProduct()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAllProduct().
        //   See https://diff.blue/R013 to resolve this issue.

        (new CustomerController()).getAllProduct();
    }

    /**
     * Method under test: {@link CustomerController#getProductById(int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetProductById() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.thanos.SecurityDemo.controller.CustomerController.getProductById(CustomerController.java:34)
        //   In order to prevent getProductById(int)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getProductById(int).
        //   See https://diff.blue/R013 to resolve this issue.

        (new CustomerController()).getProductById(1);
    }

    /**
     * Method under test: {@link CustomerController#getCustomerById(int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetCustomerById() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.thanos.SecurityDemo.controller.CustomerController.getCustomerById(CustomerController.java:39)
        //   In order to prevent getCustomerById(int)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getCustomerById(int).
        //   See https://diff.blue/R013 to resolve this issue.

        (new CustomerController()).getCustomerById(1);
    }

    /**
     * Method under test: {@link CustomerController#addCustomer(Customer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAddCustomer() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.thanos.SecurityDemo.controller.CustomerController.addCustomer(CustomerController.java:45)
        //   In order to prevent addCustomer(Customer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   addCustomer(Customer).
        //   See https://diff.blue/R013 to resolve this issue.

        CustomerController customerController = new CustomerController();

        Customer customer = new Customer();
        customer.setAge(1);
        customer.setEmail("jane.doe@example.org");
        customer.setId(1);
        customer.setName("Name");
        customer.setProductList(new ArrayList<>());
        customerController.addCustomer(customer);
    }

    /**
     * Method under test: {@link CustomerController#addCustomer(Customer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAddCustomer2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.thanos.SecurityDemo.controller.CustomerController.addCustomer(CustomerController.java:45)
        //   In order to prevent addCustomer(Customer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   addCustomer(Customer).
        //   See https://diff.blue/R013 to resolve this issue.

        CustomerController customerController = new CustomerController();

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

        Customer customer2 = new Customer();
        customer2.setAge(1);
        customer2.setEmail("jane.doe@example.org");
        customer2.setId(1);
        customer2.setName("Name");
        customer2.setProductList(new ArrayList<>());

        Customer customer3 = new Customer();
        customer3.setAge(1);
        customer3.setEmail("jane.doe@example.org");
        customer3.setId(1);
        customer3.setName("Name");
        customer3.setProductList(new ArrayList<>());

        Customer customer4 = new Customer();
        customer4.setAge(1);
        customer4.setEmail("jane.doe@example.org");
        customer4.setId(1);
        customer4.setName("Name");
        customer4.setProductList(new ArrayList<>());
        Customer customer5 = mock(Customer.class);
        when(customer5.setAge(anyInt())).thenReturn(customer);
        when(customer5.setEmail((String) any())).thenReturn(customer1);
        when(customer5.setId((Integer) any())).thenReturn(customer2);
        when(customer5.setName((String) any())).thenReturn(customer3);
        when(customer5.setProductList((java.util.List<Product>) any())).thenReturn(customer4);
        customer5.setAge(1);
        customer5.setEmail("jane.doe@example.org");
        customer5.setId(1);
        customer5.setName("Name");
        customer5.setProductList(new ArrayList<>());
        customerController.addCustomer(customer5);
    }

    /**
     * Method under test: {@link CustomerController#updateCustomer(int, Customer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateCustomer() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.thanos.SecurityDemo.controller.CustomerController.updateCustomer(CustomerController.java:51)
        //   In order to prevent updateCustomer(int, Customer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateCustomer(int, Customer).
        //   See https://diff.blue/R013 to resolve this issue.

        CustomerController customerController = new CustomerController();

        Customer customer = new Customer();
        customer.setAge(1);
        customer.setEmail("jane.doe@example.org");
        customer.setId(1);
        customer.setName("Name");
        customer.setProductList(new ArrayList<>());
        customerController.updateCustomer(1, customer);
    }

    /**
     * Method under test: {@link CustomerController#updateCustomer(int, Customer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateCustomer2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.thanos.SecurityDemo.controller.CustomerController.updateCustomer(CustomerController.java:51)
        //   In order to prevent updateCustomer(int, Customer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateCustomer(int, Customer).
        //   See https://diff.blue/R013 to resolve this issue.

        CustomerController customerController = new CustomerController();

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

        Customer customer2 = new Customer();
        customer2.setAge(1);
        customer2.setEmail("jane.doe@example.org");
        customer2.setId(1);
        customer2.setName("Name");
        customer2.setProductList(new ArrayList<>());

        Customer customer3 = new Customer();
        customer3.setAge(1);
        customer3.setEmail("jane.doe@example.org");
        customer3.setId(1);
        customer3.setName("Name");
        customer3.setProductList(new ArrayList<>());

        Customer customer4 = new Customer();
        customer4.setAge(1);
        customer4.setEmail("jane.doe@example.org");
        customer4.setId(1);
        customer4.setName("Name");
        customer4.setProductList(new ArrayList<>());
        Customer customer5 = mock(Customer.class);
        when(customer5.setAge(anyInt())).thenReturn(customer);
        when(customer5.setEmail((String) any())).thenReturn(customer1);
        when(customer5.setId((Integer) any())).thenReturn(customer2);
        when(customer5.setName((String) any())).thenReturn(customer3);
        when(customer5.setProductList((java.util.List<Product>) any())).thenReturn(customer4);
        customer5.setAge(1);
        customer5.setEmail("jane.doe@example.org");
        customer5.setId(1);
        customer5.setName("Name");
        customer5.setProductList(new ArrayList<>());
        customerController.updateCustomer(1, customer5);
    }

    /**
     * Method under test: {@link CustomerController#deleteCustomer(int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteCustomer() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.thanos.SecurityDemo.controller.CustomerController.deleteCustomer(CustomerController.java:57)
        //   In order to prevent deleteCustomer(int)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   deleteCustomer(int).
        //   See https://diff.blue/R013 to resolve this issue.

        (new CustomerController()).deleteCustomer(1);
    }
}

