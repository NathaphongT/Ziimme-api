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
import com.ziimme.websource.services.SaleService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1.0")
public class SaleController {

    @Autowired
    private SaleService service;

    @RequestMapping(value = "sale", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<List<Sale>> getAllSale() {
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "sale_base/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<Sale> getUsersById(@PathVariable("id") int sale_id) {
        return new ResponseEntity<>(this.service.getById(sale_id), HttpStatus.OK);
    }

    @RequestMapping(value = "sale/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<Object> getByIdsale(@PathVariable("id") int sale_id) {
        return service.findByIdSale(sale_id);
    }

    @RequestMapping(value = "sale_cus/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<Object> getByIdcus(@PathVariable("id") int cus_id) {
        return service.findByIdCus(cus_id);
    }

    // @RequestMapping(value = "sale_con/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    // public ResponseEntity<Object> getByIdConsult(@PathVariable("id") int sale_consultant) {
    //     return service.findByIdConsult(sale_consultant);
    // }

    @RequestMapping(value = "sale", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public ResponseEntity<Sale> createsales(@RequestBody Sale sales, HttpServletRequest request) {
        try {
            return new ResponseEntity<>(this.service.create(sales, request), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "sale/{id}", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
    public ResponseEntity<Sale> updateSales(@PathVariable("id") int sale_id,
            @RequestBody Sale sale,
            HttpServletRequest request) {
        return new ResponseEntity<>(this.service.update(sale_id, sale, request), HttpStatus.OK);
    }

    @RequestMapping(value = "sale/{id}", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8")
    public ResponseEntity<HttpStatus> deleteSales(@PathVariable("id") int sale_id,
            HttpServletRequest request) {
        try {
            this.service.delete(sale_id, request);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
