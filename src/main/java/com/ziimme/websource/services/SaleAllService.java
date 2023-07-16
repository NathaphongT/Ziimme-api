package com.ziimme.websource.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ziimme.websource.exception.ResourceNotFoundException;
import com.ziimme.websource.json.res.ResponseJson;
import com.ziimme.websource.models.Sale;
import com.ziimme.websource.models.SaleAll;
import com.ziimme.websource.models.SaleCut;
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

    public ResponseEntity<Object> findByIdSaleAll(int cusId) {
        ResponseJson responseJson = new ResponseJson();
        List<SaleAll> UserList = this.saleAllRepository.findByIdSaleAll(cusId);
        responseJson.setData(UserList);
        return new ResponseEntity<>(UserList, HttpStatus.OK);
    }

}
