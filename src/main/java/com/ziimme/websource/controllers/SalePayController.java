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

import com.ziimme.websource.models.SalePay;
import com.ziimme.websource.services.SalePayService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/backend/api/v1.0")
public class SalePayController {
     @Autowired
     private SalePayService salePayService;

     @RequestMapping(value = "sale_pay", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
     public ResponseEntity<List<SalePay>> getAllSalePay() {
          return new ResponseEntity<>(this.salePayService.getAll(), HttpStatus.OK);
     }

     @RequestMapping(value = "sale_pay/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
     public ResponseEntity<Object> findByIdSalePay(@PathVariable("id") int saleProductId) {
          return salePayService.getById(saleProductId);
     }

     @RequestMapping(value = "sale_pay_cus/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
     public ResponseEntity<Object> findByIdSaleCus(@PathVariable("id") int cusId) {
          return salePayService.getByIdCus(cusId);
     }

     @RequestMapping(value = "sale_pay", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
     public ResponseEntity<SalePay> createsales(@RequestBody SalePay salePay, HttpServletRequest request) {
          try {
               return new ResponseEntity<>(this.salePayService.create(salePay, request), HttpStatus.CREATED);
          } catch (Exception e) {
               return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
          }
     }
}
