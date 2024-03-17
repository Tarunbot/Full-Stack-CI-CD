package common.dao;

import com.github.javafaker.Faker;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
public abstract class ConfiguringDatabaseTestContainers {

    @BeforeAll
    static void beforeAll() {
        Flyway flyway=Flyway.configure().dataSource(postgreSQLContainer.getJdbcUrl(),
                postgreSQLContainer.getUsername(),
                postgreSQLContainer.getPassword()).load();
        flyway.migrate();
    }

    @DynamicPropertySource
    private static void registerDataSourceProperties(DynamicPropertyRegistry registry){
        registry.add(
                "spring.datasource.url",
                postgreSQLContainer::getJdbcUrl
        );
        registry.add(
                "spring.datasource.username",
                postgreSQLContainer::getUsername
        );
        registry.add(
                "spring.datasource.password",
                postgreSQLContainer::getPassword
        );
    }

    @Container
    protected static final PostgreSQLContainer<?> postgreSQLContainer=
            new PostgreSQLContainer<>("postgres:latest")
                    .withDatabaseName("tester-database")
                    .withUsername("root")
                    .withPassword("123");



    protected  static DataSource getDataSource(){
        return DataSourceBuilder.create().
                driverClassName(postgreSQLContainer.getDriverClassName()).
                url(postgreSQLContainer.getJdbcUrl()).
                username(postgreSQLContainer.getUsername()).
                password(postgreSQLContainer.getPassword()).build();
    }
    protected final Faker faker=new Faker();
}
