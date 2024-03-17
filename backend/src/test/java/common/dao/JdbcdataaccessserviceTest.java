package common.dao;

import com.github.javafaker.Faker;
import common.Entity.Customer;
import common.Mapper.CustomerMapper;
import common.dto.CustomerDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.testcontainers.shaded.org.checkerframework.checker.units.qual.C;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JdbcdataaccessserviceTest extends ConfiguringDatabaseTestContainers{

    private  Jdbcdataaccessservice jdbcdataaccessservice;
    private static final CustomerMapper customerMapper=new CustomerMapper();

    @BeforeEach
    void setup(){
        jdbcdataaccessservice=new Jdbcdataaccessservice(
                new JdbcTemplate(getDataSource()),
                customerMapper
                );
    }
    @Test
    void getAllCustomers() {
        CustomerDto customer=new CustomerDto(faker.name().fullName(),
                faker.internet().safeEmailAddress()+"-"+ UUID.randomUUID(),
                20);

        jdbcdataaccessservice.addCustomer(customer);

        List<Customer> result=jdbcdataaccessservice.getAllCustomers();
        assertThat(result).isNotNull();

    }

    @Test
    void getCustomerById() {
        CustomerDto customer=new CustomerDto(faker.name().fullName(),
                faker.internet().safeEmailAddress()+"-"+ UUID.randomUUID(),
                20);

        jdbcdataaccessservice.addCustomer(customer);

        assertThat(jdbcdataaccessservice.getAllCustomers().stream().filter(c-> c.getId()==1).findFirst()).isNotNull();
    }

    @Test
    void addCustomer() {
    }

    @Test
    void updateCustomer() {
    }
}