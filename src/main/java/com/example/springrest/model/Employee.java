package com.example.springrest.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class Employee {
    private @Id @GeneratedValue
    long ID;
    private String name;
    private String role;

    Employee() {}

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }
}
