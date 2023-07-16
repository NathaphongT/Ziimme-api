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

import com.ziimme.websource.models.SaleEmployee;
import com.ziimme.websource.services.SaleEmployeeService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/backend/api/v1.0")
public class SaleEmployeeController {

    @Autowired
    SaleEmployeeService service;

    @RequestMapping(value = "sales/{saleId:.*}/sale_employee", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<List<SaleEmployee>> getAllWarehouseFarmCategory(
            @PathVariable(value = "saleId") int saleId) {
        return new ResponseEntity<>(this.service.getBysaleId(saleId), HttpStatus.OK);
    }

    @RequestMapping(value = "sales/{saleId}/sale_employee", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public ResponseEntity<List<SaleEmployee>> createWarehouseFarmCategory(
            @PathVariable(value = "saleId") int saleId,
            @RequestBody List<SaleEmployee> saleConsultant,
            HttpServletRequest request) {
        try {
            return new ResponseEntity<>(this.service.create(saleId, saleConsultant, request),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "sale_employee/{id}", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8")
    public ResponseEntity<HttpStatus> deleteWarehouseFarmCategory(@PathVariable("id") int consultantId,
            HttpServletRequest request) {
        try {
            this.service.delete(consultantId, request);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "sales/{saleId}/sale_employee", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8")
    public ResponseEntity<HttpStatus> deleteWarehouseFarmCategoryBysaleId(
            @PathVariable("saleId") int saleId,
            HttpServletRequest request) {
        try {
            this.service.deleteBysaleId(saleId, request);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}