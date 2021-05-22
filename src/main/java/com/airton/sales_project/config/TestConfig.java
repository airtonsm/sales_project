package com.airton.sales_project.config;

import com.airton.sales_project.entities.User;
import com.airton.sales_project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test") // valor igual ao nomeado no application.properties.
public class TestConfig implements CommandLineRunner { // class for population the DB

    @Autowired //resolver associações entre a classe principal e o repository
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception { // método que executa  comandos quando é iniciado.

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988238383", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "9777777", "1231312");

        userRepository.saveAll(Arrays.asList(u1, u2)); // salvando users no DB

    }
}
