package org.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Configuration
@PropertySource("resources/config.properties")
@ComponentScan("org.example")
public class SpringConfig {
//    @Value("${spring.datasource.driver}")
    private String driver = "org.postgresql.Driver";
//    @Value("${spring.datasource.url}")
    private String url = "jdbc:postgresql://localhost/Pizza";
//    @Value("${spring.datasource.username}")
    private String username = "postgres";
//    @Value("${spring.datasource.password}")
    private String password = "Trazyn";
    @Bean
    public DataSource dataSource()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
    @Bean
    public JdbcTemplate jdbcTemplate()
    {
        return new JdbcTemplate(dataSource());
    }
    @Bean
    public Connection connection() throws SQLException
    {
        java.sql.Driver driver = new org.postgresql.Driver();
        DriverManager.registerDriver(driver);
        return DriverManager.getConnection(url, username,
                password);
    }
}
