package common.service;

import common.Entity.Customer;
import common.dao.CustomerDao;
import common.dto.CustomerDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Qualifier;
import org.testcontainers.shaded.org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerDao customerDao;

    private CustomerService customerService;


    @BeforeEach
    void setUp() {
        customerService=new CustomerService(customerDao);
    }

    @Test
    void getCustomers() {
         customerService.getCustomers();
         verify(customerDao).getAllCustomers();
    }

    @Test
    void addCustomer() {
        customerService.addCustomer(new CustomerDto(null,null,null));
           when(customerDao.addCustomer(Mockito.any(CustomerDto.class))).thenReturn(new Customer(null,null,null));
           assertThat(customerService.addCustomer(new CustomerDto(null,null,null))).isNotNull();
    }

    @Test
    void getCustomer() {
    }

    @Test
    void updateCustomer() {
    }
}