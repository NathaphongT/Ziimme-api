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

import com.ziimme.websource.models.Customer;
import com.ziimme.websource.services.CustomerService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1.0")
public class CustomerController {
    @Autowired
    CustomerService service;

    @RequestMapping(value = "customer", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<List<Customer>> getAllLogs() {
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "customer", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public ResponseEntity<Customer> createCourses(@RequestBody Customer customers) {
        try {
            return new ResponseEntity<>(this.service.create(customers), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "customer/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<Customer> getUsersById(@PathVariable("id") int cus_id) {
        return new ResponseEntity<>(this.service.getById(cus_id), HttpStatus.OK);
    }

    @RequestMapping(value = "customer/{id}", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
    public ResponseEntity<Customer> updateCourses(@PathVariable("id") int cus_id,
            @RequestBody Customer customer,
            HttpServletRequest request) {
        return new ResponseEntity<>(this.service.update(cus_id, customer, request), HttpStatus.OK);
    }

    @RequestMapping(value = "customer/{id}", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8")
    public ResponseEntity<HttpStatus> deleteCourses(@PathVariable("id") int cus_id,
            HttpServletRequest request) {
        try {
            this.service.delete(cus_id, request);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
