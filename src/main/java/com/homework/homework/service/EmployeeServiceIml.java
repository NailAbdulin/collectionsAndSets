package com.homework.homework.service;

import com.homework.homework.exception.EmployeeNotFoundException;
import com.homework.homework.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceIml implements EmployeeService {
    List<Employee> employees = new ArrayList<>();

    @Override
    public List<Employee> printAll() {
        return employees;
    }

    @Override
    public boolean remove(String name, String surname) {
        Employee forRemove = new Employee(name,surname);
        if (employees.remove(forRemove)) {
            return true;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public boolean completeCollection() {
        employees.add(new Employee("Petrov", "Stepan"));
        employees.add(new Employee("Ivanov", "Petr"));
        employees.add(new Employee("Burunov", "Sergei"));
        employees.add(new Employee("Ostachkova", "Olga"));
        employees.add(new Employee("Volkov", "Egor"));
        employees.add(new Employee("Babes", "Vera"));
        return true;
    }

    @Override
    public Employee search(String name, String surname) {
        Employee employeeForSearch = new Employee(name,surname);
        if (employees.contains(employeeForSearch)) {
            return employeeForSearch;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public boolean add(String name, String surname) {
        Employee forRemove = new Employee(name, surname);
        if (employees.contains(forRemove)) {
            throw new EmployeeNotFoundException("Сотрудник с таким именем есть");
        }
        return employees.add(new Employee(name, surname));
    }
}
