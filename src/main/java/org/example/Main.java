package org.example;

import org.example.Dao.PizzaDao;
import org.example.Models.Pizza;
import org.example.config.SpringConfig;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class Main {
    @Autowired
    public static PizzaDao pizzaDao = new PizzaDao(new SpringConfig().jdbcTemplate());
    public static void main(String[] args) {
        System.out.println("enter pizza name");
        Scanner scanner = new Scanner(System.in);
        Pizza pizza = new Pizza();
        pizza.setName(scanner.nextLine());
        pizza = pizzaDao.save(pizza);
        System.out.println("id " + pizza.getId());
    }
}