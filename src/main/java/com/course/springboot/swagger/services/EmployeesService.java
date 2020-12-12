package com.course.springboot.swagger.services;

import com.course.springboot.swagger.config.error.RestException;
import com.course.springboot.swagger.vo.Employee;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeesService {

    List<Employee> getEmployees(String name, String surname, Integer office, Pageable pageable);

    Employee getEmployee(int id) throws RestException;

    void createEmployee(Employee employee) throws RestException;

    void updateEmployee(int id, Employee employee) throws RestException;

    void deleteEmployee(int id) throws RestException;
}
