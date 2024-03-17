package common.controller;

import common.Entity.Customer;

import common.dto.CustomerDto;
import common.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CustomerController {
    private final CustomerService customerService;




    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    Logger logge= LoggerFactory.getLogger(CustomerController.class);



    @GetMapping("/get-Customers")
    public List<Customer> getCustomer(){
        logge.info("here only..................");
         return customerService.getCustomers();
    }

    @PostMapping("/add-Customer")
    public Customer addCustomer(@RequestBody CustomerDto customerDto){
        logge.info("here only..................");
        return customerService.addCustomer(customerDto);
    }

    @PostMapping("/update-Customer")
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }

    @GetMapping("/get-Customer/{id}")
    public Customer getCustomer(@PathVariable("id") Integer id){
        return customerService.getCustomer(id);
    }
}
