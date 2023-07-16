package com.ziimme.websource.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ziimme.websource.models.Sale;
import com.ziimme.websource.models.SaleAll;
import com.ziimme.websource.services.SaleAllService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/backend/api/v1.0")
public class SaleAllController {
     @Autowired
     private SaleAllService service;

     // Read operation
     @RequestMapping(value = "sales_all", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
     public List<SaleAll> getAll() {
          return this.service.findAll();
     }

     @RequestMapping(value = "sales_all_cus/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
     public ResponseEntity<Object> getByIdsale(@PathVariable("id") int cusId) {
          return service.findByIdSaleAll(cusId);
     }

}
