package com.ziimme.websource.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ziimme.websource.exception.ResourceNotFoundException;
import com.ziimme.websource.json.res.ResponseJson;
import com.ziimme.websource.models.SaleAll;
import com.ziimme.websource.repository.SaleAllRepository;

@Service
public class SaleAllService {

    private SaleAllRepository saleAllRepository;

    @Autowired
    public void setSaleService(
            SaleAllRepository saleAllRepository) {
        this.saleAllRepository = saleAllRepository;
    }

    public List<SaleAll> findAll() {
        return this.saleAllRepository.findAll();
    }

    public ResponseEntity<List<SaleAll>> findByIdIn(int cusId) {
        ResponseJson responseJson = new ResponseJson();
        List<SaleAll> saleList = this.saleAllRepository.findById(cusId);

        // Process each SaleAll item using a for-each loop
        for (SaleAll sale : saleList) {
            // Perform some operation on each sale (e.g., update a field, calculate
            // something)
            // For example, set a flag to indicate that the sale is processed
            // sale.setProcessed(true);
            System.out.println(sale);
        }

        responseJson.setData(saleList);

        return new ResponseEntity<>(saleList, HttpStatus.OK);
    }
    public ResponseEntity<List<SaleAll>> findByIdSale(int cusId) {
        ResponseJson responseJson = new ResponseJson();
        List<SaleAll> saleList = this.saleAllRepository.findByIdSale(cusId);

        // Process each SaleAll item using a for-each loop
        for (SaleAll sale : saleList) {
            // Perform some operation on each sale (e.g., update a field, calculate
            // something)
            // For example, set a flag to indicate that the sale is processed
            // sale.setProcessed(true);
            System.out.println(sale);
        }

        responseJson.setData(saleList);

        return new ResponseEntity<>(saleList, HttpStatus.OK);
    }
}
