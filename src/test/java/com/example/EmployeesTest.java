package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class EmployeesTest {
    List<Employee> mockRepo = List.of(
            new Employee("1", 100),
            new Employee("2", 100),
            new Employee("3", 100),
            new Employee("4", 1000000),
            new Employee("5", 100),
            new Employee("6", 100),
            new Employee("7", 100),
            new Employee("8", 100)
    );
    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl(mockRepo);
    BankService bankService = Mockito.mock(BankService.class);
    Employees employees = new Employees(employeeRepository, bankService);


    @Test
    void payEmployeesShouldIncreasePaymentsForEachEmployee() {

        assertEquals(employees.payEmployees(), 8);

    }

    @Test
    void payEmployeesThrowsExceptionWhenEmployeeNotAllegeableForPayment() {

        doThrow(new RuntimeException()).when(bankService).pay(isA(String.class), eq(1000000.0));

        employees.payEmployees();

    }

    @Test
    void payEmployeesShouldIcreaseForAllegeablePayments() {

        doThrow(new RuntimeException()).when(bankService).pay(isA(String.class), eq(1000000.0));

        assertEquals(employees.payEmployees(), 7);
    }

    @Test
    void payMethodIsInvoked() {

        employees.payEmployees();

        verify(bankService, times(8)).pay(anyString(), anyDouble());

    }
}
