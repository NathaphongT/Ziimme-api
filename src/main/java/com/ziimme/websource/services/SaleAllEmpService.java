package com.ziimme.websource.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ziimme.websource.json.res.ResponseJson;
import com.ziimme.websource.models.SaleAllEmp;
import com.ziimme.websource.repository.SaleAllEmpRepository;

@Service
public class SaleAllEmpService {
     private SaleAllEmpRepository saleAllEmpRepository;

     @Autowired
     public void setSaleService(
               SaleAllEmpRepository saleAllEmpRepository) {
          this.saleAllEmpRepository = saleAllEmpRepository;
     }

     public List<SaleAllEmp> findAll() {
          return this.saleAllEmpRepository.findAll();
     }

     public ResponseEntity<Object> findByIdSaleAll(int empId) {
          ResponseJson responseJson = new ResponseJson();
          List<SaleAllEmp> UserList = this.saleAllEmpRepository.findByIdSaleAllEmp(empId);
          responseJson.setData(UserList);
          return new ResponseEntity<>(UserList, HttpStatus.OK);
     }
}
