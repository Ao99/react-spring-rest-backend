package io.ao9.reactspringrestbackend.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String firstName;
    private String lastName;
    private String description;
    private boolean onDuty;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String description, boolean onDuty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.onDuty = onDuty;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isOnDuty() {
        return this.onDuty;
    }

    public boolean getOnDuty() {
        return this.onDuty;
    }

    public void setOnDuty(boolean onDuty) {
        this.onDuty = onDuty;
    }

    public Employee id(long id) {
        this.id = id;
        return this;
    }

    public Employee firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Employee lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Employee description(String description) {
        this.description = description;
        return this;
    }

    public Employee onDuty(boolean onDuty) {
        this.onDuty = onDuty;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(description, employee.description) && onDuty == employee.onDuty;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, description, onDuty);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", description='" + getDescription() + "'" +
            ", onDuty='" + isOnDuty() + "'" +
            "}";
    }

}