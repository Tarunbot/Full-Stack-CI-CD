package common.dao;

import common.Entity.Customer;
import common.dto.CustomerDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository("list")
public class DataAccessService implements CustomerDao {

    private static List<Customer> customer;

    static{
        customer=new ArrayList<Customer>();
        customer.add(new Customer(1,"Tarun Raj","@gmail.com",26));
        customer.add(new Customer(2,"Meoww Cat","meow@gmail.com",2));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customer;
    }

    @Override
    public Optional<Customer> getCustomerById(Integer id) {
        return customer.stream().filter(c-> c.getId().equals(id)).findFirst();
    }

    @Override
    public Customer addCustomer(CustomerDto customerDto) {
        return null;
    }


    @Override
    public Customer updateCustomer(Customer customer) {
        return null;
    }
}
