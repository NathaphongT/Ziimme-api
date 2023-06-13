package com.ziimme.websource.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ziimme.websource.models.Employee;
import com.ziimme.websource.models.Users;
import com.ziimme.websource.security.TokenAuthenticationService;
import com.ziimme.websource.services.EmployeeService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1.0")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @Autowired
    private TokenAuthenticationService jwt;

    @RequestMapping(value = "employee", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<List<Employee>> getAllLogs() {
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "employee/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<Employee> getEmpById(@PathVariable("id") int emp_id) {
        return new ResponseEntity<>(this.service.getById(emp_id), HttpStatus.OK);
    }

    @RequestMapping(value = "employee", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public ResponseEntity<Employee> createEmployees(@RequestBody Employee employees, HttpServletRequest request) {
        try {
            return new ResponseEntity<>(this.service.create(employees, request), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "employee/{id}", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
    public ResponseEntity<Employee> updateEmployees(@PathVariable("id") int emp_id,
            @RequestBody Employee employee,
            HttpServletRequest request) {
        return new ResponseEntity<>(this.service.update(emp_id, employee, request), HttpStatus.OK);
    }

    @RequestMapping(value = "employee/{id}", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8")
    public ResponseEntity<HttpStatus> deleteEmployees(@PathVariable("id") int emp_id,
            HttpServletRequest request) {
        try {
            this.service.delete(emp_id, request);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
