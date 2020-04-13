package io.ao9.reactspringrestbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ao9.reactspringrestbackend.dao.EmployeeRepository;
import io.ao9.reactspringrestbackend.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository theEmployeeReposirory;

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = theEmployeeReposirory.findAll();        
        return employees;
    }

    @Override
    public Employee findById(long theId) {
        Optional<Employee> result = theEmployeeReposirory.findById(theId);
        Employee theEmployee = null;
        if(result.isPresent()) {
            theEmployee = result.get();
        }        
        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {
        theEmployeeReposirory.save(theEmployee);
    }

    @Override
    public void deleteById(Employee theEmployee) {
        theEmployeeReposirory.delete(theEmployee);
    }

    @Override
    public void deleteAll() {
        theEmployeeReposirory.deleteAll();
    }

    @Override
    public List<Employee> findByLastNameContaining(String theLastName) {
        List<Employee> employees = theEmployeeReposirory.findByLastNameContaining(theLastName);        
        return employees;
    }
}