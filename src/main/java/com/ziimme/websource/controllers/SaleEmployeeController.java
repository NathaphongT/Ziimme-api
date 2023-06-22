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
import com.ziimme.websource.models.SaleEmployee;
import com.ziimme.websource.repository.SaleEmployeeRepository;
import com.ziimme.websource.services.SaleEmployeeService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1.0")
public class SaleEmployeeController {

    @Autowired
    SaleEmployeeService service;

    @RequestMapping(value = "sales/{sale_id}/sale_employee", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<List<SaleEmployee>> getAllWarehouseFarmCategory(
            @PathVariable(value = "sale_id") int sale_id) {
        return new ResponseEntity<>(this.service.getByWarehouseId(sale_id), HttpStatus.OK);
    }

    @RequestMapping(value = "sales/{sale_id:.*}/sale_employee", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public ResponseEntity<List<SaleEmployee>> createWarehouseFarmCategory(
            @PathVariable(value = "sale_id") int sale_id,
            @RequestBody List<SaleEmployee> saleConsultant,
            HttpServletRequest request) {
        try {
            return new ResponseEntity<>(this.service.create(sale_id, saleConsultant, request),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
