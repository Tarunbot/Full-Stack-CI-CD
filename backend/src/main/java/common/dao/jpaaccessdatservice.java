package common.dao;

import common.Entity.Customer;
import common.dto.CustomerDto;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository("jpa")
public class jpaaccessdatservice implements CustomerDao {


    private final JpaController jpaController;

    public jpaaccessdatservice(JpaController jpaController) {
        this.jpaController = jpaController;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return jpaController.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Integer id) {
        return jpaController.findById(id);
    }

    @Override
    public Customer addCustomer(CustomerDto customerDto) {
        return jpaController.save(new Customer(customerDto.getName(),customerDto.getEmail(),customerDto.getAge()));
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return jpaController.save(customer);
    }


}
