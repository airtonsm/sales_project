package com.airton.sales_project.config;

import com.airton.sales_project.entities.Order;
import com.airton.sales_project.entities.User;
import com.airton.sales_project.entities.enums.OrderStatus;
import com.airton.sales_project.repositories.OrderRepository;
import com.airton.sales_project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test") // valor igual ao nomeado no application.properties.
public class TestConfig implements CommandLineRunner { // class for population the DB

    @Autowired //resolver associações entre a classe principal e o repository
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public void run(String... args) throws Exception { // método que executa  comandos quando é iniciado.

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988238383", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "9777777", "1231312");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.PAID);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.WAITING_PAYMENT);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.WAITING_PAYMENT);

        userRepository.saveAll(Arrays.asList(u1, u2)); // salvando users no DB

       orderRepository.saveAll(Arrays.asList(o1,o2,o3));



    }
}
