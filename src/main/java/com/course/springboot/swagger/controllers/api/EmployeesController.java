package com.course.springboot.swagger.controllers.api;

import com.course.springboot.swagger.config.error.RestException;
import com.course.springboot.swagger.controllers.dto.EmployeeDTO;
import com.course.springboot.swagger.controllers.dto.ListEmployeesDTO;
import com.course.springboot.swagger.controllers.mappers.EmployeeToEmployeeDTOMapper;
import com.course.springboot.swagger.controllers.mappers.EmployeeToListEmployeesDTOMapper;
import com.course.springboot.swagger.services.EmployeesService;
import com.course.springboot.swagger.vo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * ControllerImpl for Employees Services
 */
@RestController
public class EmployeesController implements EmployeesApi {

    @Autowired
    private EmployeesService employeesService;

    @Override
    public ResponseEntity<List<ListEmployeesDTO>> getEmployees(String name, String surname, Integer office, Pageable pageable) {
        List<Employee> employeesAux = employeesService.getEmployees(name, surname, office, pageable);
        List<ListEmployeesDTO> response = EmployeeToListEmployeesDTOMapper.INSTANCE.employeeToListEmployeesDTO(employeesAux);
        return ResponseEntity.ok().body(response);
    }

    @Override
    public ResponseEntity<EmployeeDTO> getEmployee(int id) throws RestException {
        // Search for employee
        Employee employeeAux = employeesService.getEmployee(id);

        // Check if null
        if (employeeAux == null) {
            return ResponseEntity.notFound().build();
        }

        // Employee to EmployeeDTO
        EmployeeDTO employeeDTO = EmployeeToEmployeeDTOMapper.INSTANCE.employeeToEmployeeDTO(employeeAux);
        return ResponseEntity.ok().body(employeeDTO);
    }

    @Override
    public ResponseEntity<Void> createEmployee(EmployeeDTO employeeDTO) throws RestException {
        // Map EmployeeDTO to Employee
        Employee employee = EmployeeToEmployeeDTOMapper.INSTANCE.employeeDTOToEmployee(employeeDTO);
        employeesService.createEmployee(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> updateEmployee(int id, @Valid EmployeeDTO employeeDTO) throws RestException {
        // Map EmployeeDTO to Employee
        Employee employeeUpdate = EmployeeToEmployeeDTOMapper.INSTANCE.employeeDTOToEmployee(employeeDTO);
        employeesService.updateEmployee(id, employeeUpdate);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteEmployee(int id) throws RestException {
        employeesService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
