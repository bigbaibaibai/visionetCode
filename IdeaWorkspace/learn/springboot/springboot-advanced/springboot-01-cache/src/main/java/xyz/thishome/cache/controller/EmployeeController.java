package xyz.thishome.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.thishome.cache.bean.Employee;
import xyz.thishome.cache.service.EmloyeeService;

@RestController
public class EmployeeController {

    @Autowired
    private EmloyeeService emloyeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable Integer id) {
        return emloyeeService.getEmp(id);
    }

    @PostMapping("/emp")
    public Employee updateEmp(Employee employee){
        emloyeeService.updateEmp(employee);
        return employee;
    }

}
