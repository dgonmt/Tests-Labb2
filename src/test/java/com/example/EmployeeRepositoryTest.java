package com.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeRepositoryTest {

    List<Employee> mockRepo = List.of(
            new Employee("1", 100),
            new Employee("2", 100),
            new Employee("3", 100),
            new Employee("4", 100),
            new Employee("5", 100),
            new Employee("6", 100),
            new Employee("7", 100),
            new Employee("8", 100)
            );
    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl(mockRepo);

    @Test
    void saveAddsNewEmployee() {

        Employee employee = new Employee("9", 100);
        employeeRepository.save(employee);

        assertEquals(9, employeeRepository.findAll().size());

    }

    @Test
    void saveUpdatesExistingEmployee() {

        Employee employee = new Employee("1", 200);
        employeeRepository.save(employee);

        assertEquals(200, employeeRepository.findAll().get(0).getSalary());

    }





}
