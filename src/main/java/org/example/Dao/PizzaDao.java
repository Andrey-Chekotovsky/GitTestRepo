package org.example.Dao;

import lombok.RequiredArgsConstructor;
import org.example.Models.Pizza;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PizzaDao {
    private final JdbcTemplate jdbcTemplate;

    public Pizza save(Pizza pizza) {
        pizza.setId(jdbcTemplate.query("INSERT INTO pizzas(name) " +
                "VALUES (?) RETURNING id;", new Object[]{pizza.getName()}, new IdMapper()).stream()
                .findAny().orElse(null));
        return pizza;
    }
}
