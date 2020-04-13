package io.ao9.reactspringrestbackend.service;

import java.util.List;

import io.ao9.reactspringrestbackend.entity.Employee;

public interface EmployeeService {
    public List<Employee> findAll();

	public Employee findById(long theId);
    
    public void save(Employee theEmployee);

	public void deleteById(Employee theEmployee);

	public void deleteAll();

	public List<Employee> findByLastNameContaining(String theLastName);
}