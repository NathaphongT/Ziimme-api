package com.ziimme.websource.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ziimme.websource.exception.ResourceNotFoundException;
import com.ziimme.websource.models.SaleProduct;
import com.ziimme.websource.repository.SaleProductRepository;
import com.ziimme.websource.repository.SaleRepository;
import com.ziimme.websource.security.TokenAuthenticationService;
import com.ziimme.websource.utils.GlobalUtil;

@Service
public class SaleProductService {
    @Autowired
    private SaleProductRepository saleProductRepository;

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private TokenAuthenticationService tokenAuthenticationService;

    public List<SaleProduct> getBysaleId(int saleId) {
        this.saleRepository.findById(saleId)
                .orElseThrow(() -> new ResourceNotFoundException("Sale", "id", saleId));

        List<SaleProduct> warehouseFarmCategories = this.saleProductRepository
                .findBySaleId(saleId);

        return warehouseFarmCategories;
    }

    public List<SaleProduct> create(int saleId, List<SaleProduct> saleProduct, HttpServletRequest request) {
        this.saleRepository.findById(saleId)
                .orElseThrow(() -> new ResourceNotFoundException("SaleID", "id", saleId));

        String username = this.tokenAuthenticationService.getUsername(request);

        List<SaleProduct> _saleProduct = new ArrayList<SaleProduct>();
        for (SaleProduct saleProducts : saleProduct) {
            SaleProduct saleProducte = new SaleProduct();
            saleProducte.setcourseId(saleProducts.getcourseId());
            saleProducte.setsaleCount(saleProducts.getsaleCount());
            saleProducte.setcusId(saleProducts.getcusId());
            saleProducte.setRecordStatus(GlobalUtil.getActiveStatus());
            saleProducte.setCreatedBy(username);
            saleProducte.setCreatedTime(GlobalUtil.getCurrentDateTime());
            saleProducte.setsaleId(saleId);

            _saleProduct.add(saleProducte);
        }
        List<SaleProduct> _saleProducts = this.saleProductRepository.saveAll(_saleProduct);

        return _saleProducts;
    }

    public List<SaleProduct> update(int saleId, List<SaleProduct> saleProduct, HttpServletRequest request) {
        this.saleRepository.findById(saleId)
                .orElseThrow(() -> new ResourceNotFoundException("SaleID", "id", saleId));

        String username = this.tokenAuthenticationService.getUsername(request);

        List<SaleProduct> _saleProduct = new ArrayList<SaleProduct>();
        for (SaleProduct saleProducts : saleProduct) {
            SaleProduct saleProducte = new SaleProduct();
            saleProducte.setcourseId(saleProducts.getcourseId());
            saleProducte.setsaleCount(saleProducts.getsaleCount());
            saleProducte.setcusId(saleProducts.getcusId());
            saleProducte.setRecordStatus(GlobalUtil.getActiveStatus());
            saleProducte.setUpdatedBy(username);
            saleProducte.setUpdatedTime(GlobalUtil.getCurrentDateTime());
            saleProducte.setsaleId(saleId);

            _saleProduct.add(saleProducte);
        }
        List<SaleProduct> _saleProducts = this.saleProductRepository.saveAll(_saleProduct);

        return _saleProducts;
    }

    public void delete(int consultantId, HttpServletRequest request) {
        SaleProduct _SaleProduct = this.saleProductRepository
                .findById(consultantId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Warehouse FarmCategory", "id", consultantId));

        String username = this.tokenAuthenticationService.getUsername(request);

        _SaleProduct.setRecordStatus(GlobalUtil.getInActiveStatus());
        _SaleProduct.setUpdatedBy(username);
        _SaleProduct.setUpdatedTime(GlobalUtil.getCurrentDateTime());

        this.saleProductRepository.save(_SaleProduct);
    }

    public void deleteBysaleId(int saleId, HttpServletRequest request) {
        this.saleRepository.findById(saleId)
                .orElseThrow(() -> new ResourceNotFoundException("Sale", "id", saleId));
        String username = this.tokenAuthenticationService.getUsername(request);

        this.saleProductRepository.deleteBySaleId(saleId);
    }

}
