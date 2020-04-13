package io.ao9.reactspringrestbackend.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.ao9.reactspringrestbackend.entity.Employee;
import io.ao9.reactspringrestbackend.service.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService theEmployeeService;

    @GetMapping(value="/employees")
    public List<Employee> findAll(@RequestParam(value = "lastName", required = false) String theLastName) {
        List<Employee> employees;
        if(theLastName == null) {
            employees = theEmployeeService.findAll();
        } else {
            employees = theEmployeeService.findByLastNameContaining(theLastName);
        }
        return employees;
    }

    @GetMapping(value="/employees/{theId}")
    public Employee findById(@PathVariable long theId) {
        Employee theEmployee = theEmployeeService.findById(theId);
        return theEmployee;
    }

    @PostMapping(value="/employees")
    public Employee create(@RequestBody Employee theEmployee) {
        theEmployee.setId(0);
        theEmployeeService.save(theEmployee);
        return theEmployee;
    }

    @PutMapping(value="employees/{theId}")
    public Employee update(@PathVariable Long theId, @RequestBody Employee theEmployee) {
        theEmployee.setId(theId);
        theEmployeeService.save(theEmployee);
        return theEmployee;
    }

    @DeleteMapping(value="/employees")
    public String deleteAll() {
        theEmployeeService.deleteAll();
        return "Deleted all employees";
    }

    @DeleteMapping(value="/employees/{theId}")
    public String deleteById(@PathVariable long theId) {
        Employee theEmployee = theEmployeeService.findById(theId);
        theEmployeeService.deleteById(theEmployee);
        return "Deleted employee id - " + theId;
    }
}