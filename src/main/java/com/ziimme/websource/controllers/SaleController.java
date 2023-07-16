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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ziimme.websource.json.res.PageResponse;
import com.ziimme.websource.json.res.ResponseJson;
import com.ziimme.websource.models.Sale;
import com.ziimme.websource.models.SaleAll;
import com.ziimme.websource.services.SaleAllService;
import com.ziimme.websource.services.SaleService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/backend/api/v1.0")
public class SaleController {

    @Autowired
    private SaleService service;

    @RequestMapping(value = "sales", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<PageResponse> searchWarehouse(
            @RequestParam(required = false) String q,
            @RequestParam(required = false) String useStatus,
            @RequestParam(defaultValue = "1", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int limit,
            @RequestParam(defaultValue = "0", required = false) int saleId,
            @RequestParam(defaultValue = "createdTime", required = false) String sort,
            @RequestParam(defaultValue = "asc", required = false) String order) {
        try {
            List<Sale> warehouses = new ArrayList<Sale>();

            Sort.Direction direction = Sort.Direction.ASC;
            if (order.equalsIgnoreCase("desc")) {
                direction = Sort.Direction.DESC;
            }

            Pageable paging = PageRequest.of(page - 1, limit, direction, sort);

            Page<Sale> salePage = this.service.search(q, saleId, paging);
            warehouses = salePage.getContent();

            PageResponse response = new PageResponse();
            response.setData(warehouses);
            response.setCurrentPage(salePage.getNumber() + 1);
            response.setTotalItems(salePage.getTotalElements());
            response.setTotalPages(salePage.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "sales", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public ResponseEntity<Sale> createSales(@RequestBody Sale sales, HttpServletRequest request) {
        try {
            return new ResponseEntity<>(this.service.create(sales, request), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "sales/{id}", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
    public ResponseEntity<Sale> updateSales(@PathVariable("id") int saleId,
            @RequestBody Sale sale,
            HttpServletRequest request) {
        return new ResponseEntity<>(this.service.update(saleId, sale, request), HttpStatus.OK);
    }

    @RequestMapping(value = "sales/{id}", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8")
    public ResponseEntity<HttpStatus> deleteSales(@PathVariable("id") int saleId,
            HttpServletRequest request) {
        try {
            this.service.delete(saleId, request);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "sales/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<Sale> getSaleById(@PathVariable("id") int saleId) {
        return new ResponseEntity<>(this.service.getById(saleId), HttpStatus.OK);
    }

    @RequestMapping(value = "sale_cus/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<Object> getByIdcus(@PathVariable("id") int cusId) {
        return service.findByIdCus(cusId);
    }

}
