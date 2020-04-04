package com.example.springrest.controllers;

import com.example.springrest.exception.EmployeeNotFoundException;
import com.example.springrest.model.Employee;
import com.example.springrest.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employee")
@RestController
public class EmployeeController {

    private final EmployeeRepository empRepo;

    public EmployeeController(EmployeeRepository empRepo) {
        this.empRepo = empRepo;
    }

    // Aggregate Root

    @GetMapping
    List<Employee> all() {
        return this.empRepo.findAll();
    }

    @PostMapping
    Employee newEmployee(@RequestBody Employee employee) {
        return this.empRepo.save(employee);
    }

    // Single Item

    @GetMapping("/{id}")
    Employee findOne(@PathVariable Long id) {
        return this.empRepo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PutMapping("/{id}")
    Employee updateEmployee(@PathVariable Long id, @RequestBody Employee newEmployee) {
        return this.empRepo.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return this.empRepo.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setID(id);
                    return this.empRepo.save(newEmployee);
                });
    }


    @DeleteMapping("/{id}")
    void deleteEmployee(@PathVariable Long id) {
        this.empRepo.deleteById(id);
    }



}
