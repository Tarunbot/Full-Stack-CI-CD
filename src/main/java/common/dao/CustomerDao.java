package common.dao;

import common.Entity.Customer;
import common.dto.CustomerDto;

import java.util.List;
import java.util.Optional;


public interface CustomerDao  {
       List<Customer> getAllCustomers();
       Optional<Customer> getCustomerById(Integer id);

       Customer addCustomer(CustomerDto customerDto);

       Customer updateCustomer(Customer customer);
}
