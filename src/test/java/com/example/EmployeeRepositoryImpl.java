package com.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository{

    private List<Employee> repository = new ArrayList<>();


    public EmployeeRepositoryImpl(List<Employee> employees) {
        repository.addAll(employees);

    }
    @Override
    public List<Employee> findAll() {
        return this.repository;
    }

    @Override
    public Employee save(Employee e) {

        boolean isFound = false;
        int employeeIndex = -1;


        for (Employee employee : repository) {
            if (employee.getId().equals(e.getId())) {
                isFound = true;
                employeeIndex = repository.indexOf(employee);
            }
        }

        if (isFound)
            repository.get(employeeIndex).setSalary(e.getSalary());

        else {
            repository.add(e);
            employeeIndex = repository.size() -1;
        }

        return repository.get(employeeIndex);
    }
}
