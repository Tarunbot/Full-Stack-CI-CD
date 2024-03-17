package common.dao;

import common.Entity.Customer;
import common.controller.CustomerController;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaController extends JpaRepository<Customer,Integer> {

    boolean existsCustomerByEmail(String email);
}
