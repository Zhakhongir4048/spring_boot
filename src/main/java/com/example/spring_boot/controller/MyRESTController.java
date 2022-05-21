package com.example.spring_boot.controller;

import com.example.spring_boot.entity.Employee;
import com.example.spring_boot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    private final EmployeeService employeeService;

    @Autowired
    public MyRESTController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{employee_id}")
    public Employee getEmployee(@PathVariable("employee_id") int id) {
        return employeeService.getEmployee(id);
    }

    // Аннотация @RequestBody связывает тело HTTP метода с параметром метода Controller-а
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return getEmployee(employee.getId());
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{employee_id}")
    public void deleteEmployee(@PathVariable("employee_id") int id) {
        employeeService.deleteEmployee(id);
    }

}