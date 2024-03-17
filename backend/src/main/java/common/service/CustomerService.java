package common.service;

import common.Entity.Customer;
import common.Error.NotFoundException;
import common.dao.CustomerDao;
import common.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerDao customerDao;

    @Autowired
    public CustomerService(@Qualifier("jpa") CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> getCustomers() {
        return customerDao.getAllCustomers();
    }


    public Customer addCustomer(CustomerDto customerDto) {
        return customerDao.addCustomer(customerDto);
    }

    public Customer getCustomer(Integer id) {
        return customerDao.getCustomerById(id).orElseThrow(() -> new NotFoundException("customer with id %d not found".formatted(id)));
    }

    public Customer updateCustomer(Customer customer) {
        return customerDao.updateCustomer(customer);
    }
}
