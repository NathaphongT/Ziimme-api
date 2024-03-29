package com.ziimme.websource.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ziimme.websource.exception.ResourceNotFoundException;
import com.ziimme.websource.json.res.ResponseJson;

import com.ziimme.websource.models.Sale;
import com.ziimme.websource.models.SaleSpecification;

import com.ziimme.websource.repository.SaleRepository;

import com.ziimme.websource.security.TokenAuthenticationService;
import com.ziimme.websource.utils.GlobalUtil;

@Service
public class SaleService {

    private SaleRepository saleRepository;

    private SaleSpecification saleSpecification;
    private TokenAuthenticationService tokenAuthenticationService;

    @Autowired
    public void setSaleService(
            SaleRepository saleRepository,
            SaleSpecification saleSpecification,
            TokenAuthenticationService tokenAuthenticationService) {
        this.saleRepository = saleRepository;
        this.saleSpecification = saleSpecification;
        this.tokenAuthenticationService = tokenAuthenticationService;
    }

    public List<Sale> getAll() {
        return this.saleRepository.findAll();
    }

    public Page<Sale> search(String q, int type, Pageable pageable) {
        return this.saleRepository.findAll(saleSpecification.search(q, type), pageable);
    }

    public Sale getById(int saleId) {
        Sale sale = this.saleRepository.findById(saleId)
                .orElseThrow(() -> new ResourceNotFoundException("Sale", "id", saleId));

        return sale;
    }

    public Sale create(Sale sale, HttpServletRequest request) throws Exception {

        // check duplicate salenumber name before create
        if (this.saleRepository.findBySaleName(sale.getSaleNumber()).isPresent()) {
            throw new Exception("เลขที่เอกสารซ้ำ");
        }

        String username = this.tokenAuthenticationService.getUsername(request);

        Sale _sales = new Sale();
        _sales.setSaleNumber(sale.getSaleNumber());
        _sales.setSaleBalance(sale.getSaleBalance());
        _sales.setSalePayment(sale.getSalePayment());
        _sales.setSaleOverdue(sale.getSaleOverdue());
        _sales.setSaleDate(sale.getSaleDate());
        _sales.setSaleDetail(sale.getSaleDetail());
        _sales.setCusId(sale.getCusId());
        _sales.setRecordStatus(GlobalUtil.getActiveStatus());
        _sales.setSaleStatus(GlobalUtil.getActiveStatus());
        _sales.setCreatedBy(username);
        _sales.setCreatedTime(GlobalUtil.getCurrentDateTime());
        return this.saleRepository.save(_sales);
    }

    public Sale update(int sale_id, Sale sale, HttpServletRequest request) {
        Sale _sales = this.saleRepository.findById(sale_id)
                .orElseThrow(() -> new ResourceNotFoundException("Sale", "id", sale_id));

        String username = this.tokenAuthenticationService.getUsername(request);

        _sales.setSaleNumber(sale.getSaleNumber());
        _sales.setSaleBalance(sale.getSaleBalance());
        _sales.setSalePayment(sale.getSalePayment());
        _sales.setSaleOverdue(sale.getSaleOverdue());
        _sales.setSaleDate(sale.getSaleDate());
        _sales.setSaleDetail(sale.getSaleDetail());
        _sales.setCusId(sale.getCusId());
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

    public Sale cutDown(int sale_id, Sale sale, HttpServletRequest request) {
        Sale _sales = this.saleRepository.findById(sale_id)
                .orElseThrow(() -> new ResourceNotFoundException("Sale", "id", sale_id));

        String username = this.tokenAuthenticationService.getUsername(request);

        _sales.setSaleNumber(sale.getSaleNumber());
        _sales.setSaleBalance(sale.getSaleBalance());
        _sales.setSalePayment(sale.getSalePayment());
        _sales.setSaleOverdue(sale.getSaleOverdue());
        _sales.setSaleDate(sale.getSaleDate());
        _sales.setSaleDetail(sale.getSaleDetail());
        _sales.setCusId(sale.getCusId());
        _sales.setSaleCutDownDetail(sale.getSaleCutDownDetail());
        _sales.setSaleStatus(GlobalUtil.getInActiveStatus());
        _sales.setRecordStatus(GlobalUtil.getActiveStatus());
        _sales.setUpdatedBy(username);
        _sales.setUpdatedTime(GlobalUtil.getCurrentDateTime());

        _sales = this.saleRepository.save(_sales);

        return _sales;
    }

    public ResponseEntity<Object> findByIdSale(int saleId) {
        ResponseJson responseJson = new ResponseJson();
        List<Sale> UserList = this.saleRepository.findByIdSale(saleId);
        responseJson.setData(UserList);
        return new ResponseEntity<>(UserList, HttpStatus.OK);
    }

    public ResponseEntity<Object> findByIdCus(int cusId) {
        ResponseJson responseJson = new ResponseJson();
        List<Sale> UserList = this.saleRepository.findByIdCus(cusId);
        responseJson.setData(UserList);
        return new ResponseEntity<>(UserList, HttpStatus.OK);
    }

    public ResponseEntity<Object> saleAllService(HttpServletRequest request) {
        return null;
    }

}
