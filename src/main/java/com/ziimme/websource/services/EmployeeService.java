package com.ziimme.websource.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ziimme.websource.exception.ResourceNotFoundException;
import com.ziimme.websource.models.Employee;
import com.ziimme.websource.models.EmployeeSpecification;
import com.ziimme.websource.models.SaleSpecification;
import com.ziimme.websource.repository.EmployeeRepository;
import com.ziimme.websource.repository.SaleRepository;
import com.ziimme.websource.security.TokenAuthenticationService;
import com.ziimme.websource.utils.GlobalUtil;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private EmployeeSpecification employeeSpecification;
    private TokenAuthenticationService tokenAuthenticationService;

    @Autowired
    public void setWarehouseService(
            EmployeeRepository employeeRepository,
            EmployeeSpecification employeeSpecification,
            TokenAuthenticationService tokenAuthenticationService) {
        this.employeeRepository = employeeRepository;
        this.employeeSpecification = employeeSpecification;
        this.tokenAuthenticationService = tokenAuthenticationService;
    }

    public List<Employee> getAll() {
        return this.employeeRepository.findAll();
    }

    public Page<Employee> search(String q, Pageable pageable) {
        return this.employeeRepository.findAll(employeeSpecification.searchByName(q), pageable);
    }

    public Employee getById(int emp_id) {
        Employee employee = this.employeeRepository.findById(emp_id)
                .orElseThrow(() -> new ResourceNotFoundException("Emp", "id", emp_id));

        return employee;
    }

    public Employee create(Employee employees, HttpServletRequest request) {
        String username = this.tokenAuthenticationService.getUsername(request);

        Employee _employee = new Employee();
        _employee.setEmpFullname(employees.getEmpFullname());
        _employee.setEmpNickname(employees.getEmpNickname());
        _employee.setEmpBirthday(employees.getEmpBirthday());
        _employee.setEmpTelephone(employees.getEmpTelephone());
        _employee.setEmpEmail(employees.getEmpEmail());
        _employee.setEmpStatus(employees.getEmpStatus());
        _employee.setEmpPosition(employees.getEmpPosition());
        _employee.setEmpBranch(employees.getEmpBranch());
        _employee.setRecordStatus(GlobalUtil.getActiveStatus());
        _employee.setCreatedBy(username);
        _employee.setCreatedTime(GlobalUtil.getCurrentDateTime());
        return this.employeeRepository.save(_employee);
    }

    public Employee update(int emp_id, Employee employees, HttpServletRequest request) {
        Employee _employee = this.employeeRepository.findById(emp_id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", emp_id));

        String username = this.tokenAuthenticationService.getUsername(request);

        _employee.setEmpFullname(employees.getEmpFullname());
        _employee.setEmpNickname(employees.getEmpNickname());
        _employee.setEmpBirthday(employees.getEmpBirthday());
        _employee.setEmpTelephone(employees.getEmpTelephone());
        _employee.setEmpEmail(employees.getEmpEmail());
        _employee.setEmpStatus(employees.getEmpStatus());
        _employee.setEmpPosition(employees.getEmpPosition());
        _employee.setEmpBranch(employees.getEmpBranch());
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
