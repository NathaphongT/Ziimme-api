package com.ziimme.websource.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ziimme.websource.exception.ResourceNotFoundException;
import com.ziimme.websource.json.res.ResponseJson;
import com.ziimme.websource.models.Sale;
import com.ziimme.websource.repository.SaleRepository;
import com.ziimme.websource.security.TokenAuthenticationService;
import com.ziimme.websource.utils.GlobalUtil;

@Service
public class SaleService {
    private SaleRepository saleRepository;
    private TokenAuthenticationService tokenAuthenticationService;

    @Autowired
    public void setSaleService(SaleRepository saleRepository,
            TokenAuthenticationService tokenAuthenticationService) {
        this.saleRepository = saleRepository;
        this.tokenAuthenticationService = tokenAuthenticationService;
    }

    public List<Sale> getAll() {
        return this.saleRepository.findAll();
    }

    public Sale getById(int sale_id) {
        Sale sales = this.saleRepository.findById(sale_id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", sale_id));

        return sales;
    }

    public ResponseEntity<Object> findByIdSale(int sale_id) {
        ResponseJson responseJson = new ResponseJson();
        List<Sale> UserList = this.saleRepository.findByIdSale(sale_id);
        responseJson.setData(UserList);
        return new ResponseEntity<>(UserList, HttpStatus.OK);
    }

    public ResponseEntity<Object> findByIdCus(int cus_id) {
        ResponseJson responseJson = new ResponseJson();
        List<Sale> UserList = this.saleRepository.findByIdCus(cus_id);
        responseJson.setData(UserList);
        return new ResponseEntity<>(UserList, HttpStatus.OK);
    }

    // public ResponseEntity<Object> findByIdConsult(int sale_consultant) {
    // ResponseJson responseJson = new ResponseJson();
    // List<Sale> UserList = this.saleRepository.findByIdConsult(sale_consultant);
    // responseJson.setData(UserList);
    // return new ResponseEntity<>(UserList, HttpStatus.OK);
    // }

    // public Sale create(Sale sales, HttpServletRequest request) {
    // String username = this.tokenAuthenticationService.getUsername(request);

    // Sale _sales = new Sale();
    // _sales.setSale_number(sales.getSale_number());
    // _sales.setSale_consultant(sales.getSale_consultant());
    // _sales.setSale_product(sales.getSale_product());
    // _sales.setSale_count(sales.getSale_count());
    // _sales.setSale_pay_balance(sales.getSale_pay_balance());
    // _sales.setSale_pay(sales.getSale_pay());
    // _sales.setSale_overdue(sales.getSale_overdue());
    // _sales.setcus_id(sales.getcus_id());
    // _sales.setRecordStatus(GlobalUtil.getActiveStatus());
    // _sales.setCreatedBy(username);
    // _sales.setCreatedTime(GlobalUtil.getCurrentDateTime());
    // return this.saleRepository.save(_sales);
    // }

    public Sale create(Sale sales, HttpServletRequest request) throws Exception {

        String username = this.tokenAuthenticationService.getUsername(request);

        Sale _sales = new Sale();
        _sales.setSale_number(sales.getSale_number());
        _sales.setSale_product(sales.getSale_product());
        _sales.setSale_count(sales.getSale_count());
        _sales.setSale_pay_balance(sales.getSale_pay_balance());
        _sales.setSale_pay(sales.getSale_pay());
        _sales.setSale_overdue(sales.getSale_overdue());
        _sales.setCus_id(sales.getCus_id());
        _sales.setRecordStatus(GlobalUtil.getActiveStatus());
        _sales.setCreatedBy(username);
        _sales.setCreatedTime(GlobalUtil.getCurrentDateTime());
        return this.saleRepository.save(_sales);
    }

    public Sale update(int sale_id, Sale sale, HttpServletRequest request) {
        Sale _sales = this.saleRepository.findById(sale_id)
                .orElseThrow(() -> new ResourceNotFoundException("Sale", "id", sale_id));

        String username = this.tokenAuthenticationService.getUsername(request);

        _sales.setSale_number(sale.getSale_number());
        _sales.setSale_product(sale.getSale_product());
        _sales.setSale_count(sale.getSale_count());
        _sales.setSale_pay_balance(sale.getSale_pay_balance());
        _sales.setSale_pay(sale.getSale_pay());
        _sales.setSale_overdue(sale.getSale_overdue());
        _sales.setCus_id(sale.getCus_id());
        _sales.setRecordStatus(GlobalUtil.getActiveStatus());
        _sales.setUpdatedBy(username);
        _sales.setUpdatedTime(GlobalUtil.getCurrentDateTime());

        _sales = this.saleRepository.save(_sales);

        return _sales;
    }

    public void delete(int sale_id, HttpServletRequest request) {
        Sale _sales = this.saleRepository.findById(sale_id)
                .orElseThrow(() -> new ResourceNotFoundException("Course", "id", sale_id));

        String username = this.tokenAuthenticationService.getUsername(request);

        _sales.setRecordStatus(GlobalUtil.getInActiveStatus());
        _sales.setUpdatedBy(username);
        _sales.setUpdatedTime(GlobalUtil.getCurrentDateTime());

        this.saleRepository.save(_sales);
    }

}
