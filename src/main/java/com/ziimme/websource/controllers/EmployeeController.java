package com.ziimme.websource.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ziimme.websource.json.res.PageResponse;
import com.ziimme.websource.models.Course;
import com.ziimme.websource.models.Employee;
import com.ziimme.websource.security.TokenAuthenticationService;
import com.ziimme.websource.services.EmployeeService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/backend/api/v1.0")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @Autowired
    private TokenAuthenticationService jwt;

    @RequestMapping(value = "employee", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<PageResponse> searchCourses(
            @RequestParam(required = false) String q,
            @RequestParam(defaultValue = "1", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int limit,
            @RequestParam(defaultValue = "createdTime", required = false) String sort,
            @RequestParam(defaultValue = "asc", required = false) String order) {
        try {
            List<Employee> courses = new ArrayList<Employee>();

            Sort.Direction direction = Sort.Direction.ASC;
            if (order.equalsIgnoreCase("desc")) {
                direction = Sort.Direction.DESC;
            }

            Pageable paging = PageRequest.of(page - 1, limit, direction, sort);

            Page<Employee> coursePage = this.service.search(q, paging);
            courses = coursePage.getContent();

            PageResponse response = new PageResponse();
            response.setData(courses);
            response.setCurrentPage(coursePage.getNumber() + 1);
            response.setTotalItems(coursePage.getTotalElements());
            response.setTotalPages(coursePage.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println(ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
