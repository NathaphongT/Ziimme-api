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
import com.ziimme.websource.models.Customer;
import com.ziimme.websource.services.CustomerService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1.0")
public class CustomerController {
    @Autowired
    CustomerService service;

    @RequestMapping(value = "customer", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<PageResponse> searchCourses(
            @RequestParam(required = false) String q,
            @RequestParam(defaultValue = "1", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int limit,
            @RequestParam(defaultValue = "createdTime", required = false) String sort,
            @RequestParam(defaultValue = "asc", required = false) String order) {
        try {
            List<Customer> customers = new ArrayList<Customer>();

            Sort.Direction direction = Sort.Direction.ASC;
            if (order.equalsIgnoreCase("desc")) {
                direction = Sort.Direction.DESC;
            }

            Pageable paging = PageRequest.of(page - 1, limit, direction, sort);

            Page<Customer> customerPage = this.service.search(q, paging);
            customers = customerPage.getContent();

            PageResponse response = new PageResponse();
            response.setData(customers);
            response.setCurrentPage(customerPage.getNumber() + 1);
            response.setTotalItems(customerPage.getTotalElements());
            response.setTotalPages(customerPage.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println(ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "customer/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<Customer> getBranchById(@PathVariable("id") int cusId) {
        return new ResponseEntity<>(this.service.getById(cusId), HttpStatus.OK);
    }

    @RequestMapping(value = "customer", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public ResponseEntity<Customer> createCourses(@RequestBody Customer customers) {
        try {
            return new ResponseEntity<>(this.service.create(customers), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "customer/{id}", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
    public ResponseEntity<Customer> updateCourses(@PathVariable("id") int cusId,
            @RequestBody Customer customer,
            HttpServletRequest request) {
        return new ResponseEntity<>(this.service.update(cusId, customer, request), HttpStatus.OK);
    }

    @RequestMapping(value = "customer/{id}", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8")
    public ResponseEntity<HttpStatus> deleteCourses(@PathVariable("id") int cusId,
            HttpServletRequest request) {
        try {
            this.service.delete(cusId, request);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
