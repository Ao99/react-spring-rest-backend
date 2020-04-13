package io.ao9.reactspringrestbackend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import io.ao9.reactspringrestbackend.entity.Employee;

@CrossOrigin
@RepositoryRestResource
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByLastNameContaining(String theLastName);
    
}