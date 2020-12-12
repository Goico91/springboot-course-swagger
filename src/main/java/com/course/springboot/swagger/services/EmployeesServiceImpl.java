package com.course.springboot.swagger.services;

import com.course.springboot.swagger.commons.enums.RestExceptionE;
import com.course.springboot.swagger.config.error.RestException;
import com.course.springboot.swagger.repositories.EmployeeKnowledgeRepository;
import com.course.springboot.swagger.repositories.EmployeesRepository;
import com.course.springboot.swagger.vo.Employee;
import com.course.springboot.swagger.vo.EmployeeKnowledge;
import com.course.springboot.swagger.vo.EmployeeKnowledgeKey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service for Employees
 */
@Service
public class EmployeesServiceImpl implements EmployeesService{

    private final EmployeesRepository employeesRepository;

    private final EmployeeKnowledgeRepository employeeKnowledgeRepository;

    public EmployeesServiceImpl(EmployeesRepository employeesRepository, EmployeeKnowledgeRepository employeeKnowledgeRepository) {
        this.employeesRepository = employeesRepository;
        this.employeeKnowledgeRepository = employeeKnowledgeRepository;
    }

    @Override
    public List<Employee> getEmployees(String name, String surname, Integer office, Pageable pageable) {
        Page<Employee> employeePage = employeesRepository.findEmployeesByFilter(name, surname, office, pageable);
        return employeePage.getContent();
    }

    @Override
    public Employee getEmployee(int id) throws RestException {
        Optional<Employee> employee = employeesRepository.findById(id);
        if(!employee.isPresent()) {
            throw new RestException(RestExceptionE.ERROR_EMPLOYEE_NOT_FOUND);
        }
        return employee.get();
    }

    @Transactional
    @Override
    public void createEmployee(Employee newEmployee) throws RestException {
        Employee employeeDB = employeesRepository.findEmployeeByNameAndSurname(newEmployee.getName(), newEmployee.getSurname());

        if (employeeDB != null) {
            throw new RestException(RestExceptionE.ERROR_EMPLOYEE_ALREADY_EXISTS);
        }

        // Save Employee
        newEmployee = employeesRepository.save(newEmployee);

        // Update Knowledge
        for(EmployeeKnowledge employeeKnowledge : newEmployee.getEmployeeKnowledge()){
            employeeKnowledge.setId(new EmployeeKnowledgeKey(newEmployee.getId(), employeeKnowledge.getKnowledge().getId()));
            employeeKnowledge.setEmployee(newEmployee);

            employeeKnowledgeRepository.save(employeeKnowledge);
        }
    }

    @Override
    public void updateEmployee(int id, Employee employeeUp) throws RestException {
        Employee employeeDB = getEmployee(id);

        // Update employee
        if(!"".equals(employeeUp.getName()))
            employeeDB.setName(employeeUp.getName());
        if(!"".equals(employeeUp.getSurname()))
            employeeDB.setSurname(employeeUp.getSurname());
        if(employeeUp.getAge() != null)
            employeeDB.setAge(employeeUp.getAge());
        if(employeeUp.getOffice() != null)
            employeeDB.setOffice(employeeUp.getOffice());

        employeesRepository.save(employeeDB);
    }

    @Override
    public void deleteEmployee(int id) throws RestException {
        employeesRepository.delete(getEmployee(id));
    }
}
