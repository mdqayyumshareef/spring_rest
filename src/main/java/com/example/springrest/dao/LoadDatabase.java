package com.example.springrest.dao;

import com.example.springrest.model.Employee;
import com.example.springrest.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository empRepo) {
        return args -> {
            log.info("preloading" + empRepo.save(new Employee("Lara Croft", "Receptionist")));
            log.info("preloading" + empRepo.save(new Employee("Tom Riddle", "Web Developer")));
        };
    }
}