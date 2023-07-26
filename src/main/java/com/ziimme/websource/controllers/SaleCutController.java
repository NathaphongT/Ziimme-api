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

import com.ziimme.websource.models.Sale;
import com.ziimme.websource.models.SaleCut;
import com.ziimme.websource.services.SaleCutService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/backend/api/v1.0")
public class SaleCutController {
    @Autowired
    private SaleCutService service;

    @RequestMapping(value = "sale_cut", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<List<SaleCut>> getAllSale() {
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "sale_cut/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<Object> findByIdSaleCut(@PathVariable("id") int saleProductId) {
        return service.getById(saleProductId);
    }

    @RequestMapping(value = "sale_cut", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public ResponseEntity<SaleCut> createsales(@RequestBody SaleCut saleCut, HttpServletRequest request) {
        try {
            return new ResponseEntity<>(this.service.create(saleCut, request), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "sale_cut/{id}", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
    public ResponseEntity<SaleCut> updateSales(@PathVariable("id") int saleCutId,
            @RequestBody SaleCut saleCut,
            HttpServletRequest request) {
        return new ResponseEntity<>(this.service.update(saleCutId, saleCut, request), HttpStatus.OK);
    }

}
