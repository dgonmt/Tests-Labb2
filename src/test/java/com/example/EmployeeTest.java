package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeTest {



    @Test
    void createNewEmployeeTest() {
        Employee e = new Employee("10", 10);
        assertEquals("10", e.getId());

    }

    @Test
    void employeeGetsPaid() {
        Employee e = new Employee("10", 10);
        e.setPaid(true);
        assertTrue(e.isPaid());

    }

    @Test
    void employeeCanGetARaise() {
        Employee e = new Employee("10", 10);
        e.setSalary(1000000);
        assertEquals(1000000, e.getSalary());

    }

    @Test
    void employeeCanGetNewId() {
        Employee e = new Employee("10", 10);
        e.setId("100");
        assertEquals("100", e.getId());

    }

    @Test
    void testToString() {
        Employee e = new Employee("10", 10);
        assertEquals("Employee [id=10, salary=10.0]", e.toString());

    }

}
