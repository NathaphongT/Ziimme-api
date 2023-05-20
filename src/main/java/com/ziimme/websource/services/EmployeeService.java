package com.ziimme.websource.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziimme.websource.exception.ResourceNotFoundException;
import com.ziimme.websource.models.Employee;
import com.ziimme.websource.repository.EmployeeRepository;
import com.ziimme.websource.security.TokenAuthenticationService;
import com.ziimme.websource.utils.GlobalUtil;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TokenAuthenticationService tokenAuthenticationService;

    public List<Employee> getAll() {
        return this.employeeRepository.findAll();
    }

    public Employee create(Employee employees, HttpServletRequest request) {
        String username = this.tokenAuthenticationService.getUsername(request);

        Employee _employees = new Employee();
        _employees.setEmp_fullname(employees.getEmp_fullname());
        _employees.setEmp_nickname(employees.getEmp_nickname());
        _employees.setEmp_birthday(employees.getEmp_birthday());
        _employees.setEmp_telephone(employees.getEmp_telephone());
        _employees.setEmp_email(employees.getEmp_email());
        _employees.setEmp_status(employees.getEmp_status());
        _employees.setEmp_position(employees.getEmp_position());
        _employees.setEmp_branch(employees.getEmp_branch());
        _employees.setRecordStatus(GlobalUtil.getActiveStatus());
        _employees.setCreatedBy(username);
        _employees.setCreatedTime(GlobalUtil.getCurrentDateTime());
        return this.employeeRepository.save(_employees);
    }

    public Employee update(int emp_id, Employee employee, HttpServletRequest request) {
        Employee _employee = this.employeeRepository.findById(emp_id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", emp_id));

        String username = this.tokenAuthenticationService.getUsername(request);

        _employee.setEmp_fullname(employee.getEmp_fullname());
        _employee.setEmp_nickname(employee.getEmp_nickname());
        _employee.setEmp_birthday(employee.getEmp_birthday());
        _employee.setEmp_telephone(employee.getEmp_telephone());
        _employee.setEmp_email(employee.getEmp_email());
        _employee.setEmp_status(employee.getEmp_status());
        _employee.setEmp_position(employee.getEmp_position());
        _employee.setEmp_branch(employee.getEmp_branch());
        _employee.setUpdatedBy(username);
        _employee.setUpdatedTime(GlobalUtil.getCurrentDateTime());

        _employee = this.employeeRepository.save(_employee);

        return _employee;
    }

    public void delete(int emp_id, HttpServletRequest request) {
        Employee _employee = this.employeeRepository.findById(emp_id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", emp_id));

        String username = this.tokenAuthenticationService.getUsername(request);

        _employee.setRecordStatus(GlobalUtil.getInActiveStatus());
        _employee.setUpdatedBy(username);
        _employee.setUpdatedTime(GlobalUtil.getCurrentDateTime());

        this.employeeRepository.save(_employee);
    }

}
