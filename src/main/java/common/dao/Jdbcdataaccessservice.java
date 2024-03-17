package common.dao;

import common.Entity.Customer;
import common.Mapper.CustomerMapper;
import common.dto.CustomerDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@Repository("jdbc")
public class Jdbcdataaccessservice implements CustomerDao{

    private final JdbcTemplate jdbcTemplate;
    private final CustomerMapper customerMapper;
    public Jdbcdataaccessservice(JdbcTemplate jdbcTemplate, CustomerMapper customerMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<Customer> getAllCustomers() {
        String sql= """
                Select * from Customer;
                """;
        return jdbcTemplate.query(sql, new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Customer(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getInt("age"));
            }
        });
    }

    @Override
    public Optional<Customer> getCustomerById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Customer addCustomer(CustomerDto customerDto) {
        String sql =
                """
                         Insert Into Customer(name,email,age)
                         values(?,?,?);
                """;
        int customer=jdbcTemplate.update(sql,customerDto.getName(),customerDto.getEmail(),customerDto.getAge());
        return null;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        String sql =
                """
                         Update  Customer set name=? ,email=?,age=? where id=?;
                """;
        int response= jdbcTemplate.update(sql,customer.getName(),customer.getEmail(),customer.getAge(),customer.getId());
        return null;
    }
}
