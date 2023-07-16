package com.ziimme.websource.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ziimme.websource.models.SaleAllEmp;
import com.ziimme.websource.services.SaleAllEmpService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/backend/api/v1.0")
public class SaleAllEmpController {
     @Autowired
     private SaleAllEmpService service;

     // Read operation
     @RequestMapping(value = "sales_all_emp", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
     public List<SaleAllEmp> getAll() {
          return this.service.findAll();
     }

     @RequestMapping(value = "sales_all_emp/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
     public ResponseEntity<Object> getByIdsale(@PathVariable("id") int empId) {
          return service.findByIdSaleAll(empId);
     }
}
