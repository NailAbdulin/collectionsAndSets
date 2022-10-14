package com.homework.homework.controller;

import com.homework.homework.model.Employee;
import com.homework.homework.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/employee/")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String welcome() {return "<h1>Добро пожаловать!<h1>";}

    @GetMapping("/complete")
    public boolean completeColleection() {
        return employeeService.completeCollection();
    }

    @GetMapping("/printAll")
    public List<Employee> printAllEmployee() {
        return employeeService.printAll();
    }
    @GetMapping("/add")
    public boolean add(@RequestParam String name, @RequestParam String surname) {
        return employeeService.add(name,surname);

    } @GetMapping("/remove")
    public boolean remove(@RequestParam String name, @RequestParam String surname) {
        return employeeService.remove(name,surname);

    } @GetMapping("/search")
    public Employee search(@RequestParam String name, @RequestParam String surname) {
        return employeeService.search(name, surname);
    }
}
