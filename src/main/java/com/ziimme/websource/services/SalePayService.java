package com.ziimme.websource.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ziimme.websource.json.res.ResponseJson;

import com.ziimme.websource.models.SalePay;

import com.ziimme.websource.repository.SalePaymentRepository;

import com.ziimme.websource.security.TokenAuthenticationService;
import com.ziimme.websource.utils.GlobalUtil;

@Service
public class SalePayService {

     @Autowired
     private SalePaymentRepository salePaymentRepository;

     @Autowired
     private TokenAuthenticationService tokenAuthenticationService;

     public List<SalePay> getAll() {
          return this.salePaymentRepository.findAll();
     }

     public ResponseEntity<Object> getById(int saleProductId) {
          ResponseJson responseJson = new ResponseJson();
          List<SalePay> PayList = this.salePaymentRepository.findByIdCut(saleProductId);
          responseJson.setData(PayList);
          return new ResponseEntity<>(responseJson, HttpStatus.OK);
     }

     public ResponseEntity<Object> getByIdCus(int cusId) {
          ResponseJson responseJson = new ResponseJson();
          List<SalePay> PayList = this.salePaymentRepository.findByIdCut(cusId);
          responseJson.setData(PayList);
          return new ResponseEntity<>(responseJson, HttpStatus.OK);
     }

     public SalePay create(SalePay salePayment, HttpServletRequest request) {
          String username = this.tokenAuthenticationService.getUsername(request);

          SalePay _salePay = new SalePay();
          _salePay.setSaleExtraPay(salePayment.getSaleExtraPay());
          _salePay.setSalePayDate(salePayment.getSalePayDate());
          _salePay.setSalePayDetail(salePayment.getSalePayDetail());
          _salePay.setSalePayCourse(salePayment.getSalePayCourse());
          _salePay.setSalePayBalance(salePayment.getSalePayBalance());
          _salePay.setSaleLastPayment(salePayment.getSaleLastPayment());
          _salePay.setSalePayOver(salePayment.getSalePayOver());
          _salePay.setCourseId(salePayment.getCourseId());
          _salePay.setSaleProductId(salePayment.getSaleProductId());
          _salePay.setSaleId(salePayment.getSaleId());
          _salePay.setCusId(salePayment.getCusId());
          _salePay.setRecordStatus(GlobalUtil.getActiveStatus());
          _salePay.setCreatedBy(username);
          _salePay.setCreatedTime(GlobalUtil.getCurrentDateTime());
          return this.salePaymentRepository.save(_salePay);
     }

}
