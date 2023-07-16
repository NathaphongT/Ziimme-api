package com.ziimme.websource.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ziimme.websource.exception.ResourceNotFoundException;
import com.ziimme.websource.models.SaleEmployee;

import com.ziimme.websource.repository.SaleEmployeeRepository;
import com.ziimme.websource.repository.SaleRepository;
import com.ziimme.websource.security.TokenAuthenticationService;
import com.ziimme.websource.utils.GlobalUtil;

@Service
public class SaleEmployeeService {
    @Autowired
    private SaleEmployeeRepository saleEmployeeRepository;

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private TokenAuthenticationService tokenAuthenticationService;

    public List<SaleEmployee> getBysaleId(int saleId) {
        this.saleRepository.findById(saleId)
                .orElseThrow(() -> new ResourceNotFoundException("Sale", "id", saleId));

        List<SaleEmployee> warehouseFarmCategories = this.saleEmployeeRepository
                .findBySaleId(saleId);

        return warehouseFarmCategories;
    }

    public List<SaleEmployee> create(int saleId, List<SaleEmployee> SaleEmployee, HttpServletRequest request) {
        this.saleRepository.findById(saleId)
                .orElseThrow(() -> new ResourceNotFoundException("SaleID", "id", saleId));

        String username = this.tokenAuthenticationService.getUsername(request);

        List<SaleEmployee> _SaleEmployee = new ArrayList<SaleEmployee>();
        for (SaleEmployee SaleEmployees : SaleEmployee) {
            SaleEmployee SaleEmps = new SaleEmployee();
            SaleEmps.setempId(SaleEmployees.getempId());
            SaleEmps.setcusId(SaleEmployees.getcusId());
            SaleEmps.setRecordStatus(GlobalUtil.getActiveStatus());
            SaleEmps.setCreatedBy(username);
            SaleEmps.setCreatedTime(GlobalUtil.getCurrentDateTime());
            SaleEmps.setsaleId(saleId);

            _SaleEmployee.add(SaleEmps);
        }
        List<SaleEmployee> _saleEmployee = this.saleEmployeeRepository.saveAll(_SaleEmployee);

        return _saleEmployee;
    }

    public List<SaleEmployee> update(int saleId, List<SaleEmployee> SaleEmployee, HttpServletRequest request) {
        this.saleRepository.findById(saleId)
                .orElseThrow(() -> new ResourceNotFoundException("SaleID", "id", saleId));

        String username = this.tokenAuthenticationService.getUsername(request);

        List<SaleEmployee> _SaleEmployee = new ArrayList<SaleEmployee>();
        for (SaleEmployee SaleEmployees : SaleEmployee) {
            SaleEmployee SaleEmps = new SaleEmployee();
            SaleEmps.setempId(SaleEmployees.getempId());
            SaleEmps.setcusId(SaleEmployees.getcusId());
            SaleEmps.setRecordStatus(GlobalUtil.getActiveStatus());
            SaleEmps.setUpdatedBy(username);
            SaleEmps.setUpdatedTime(GlobalUtil.getCurrentDateTime());
            SaleEmps.setsaleId(saleId);

            _SaleEmployee.add(SaleEmps);
        }
        List<SaleEmployee> _saleEmployee = this.saleEmployeeRepository.saveAll(_SaleEmployee);

        return _saleEmployee;
    }

    public void delete(int consultantId, HttpServletRequest request) {
        SaleEmployee _saleEmployee = this.saleEmployeeRepository
                .findById(consultantId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Warehouse FarmCategory", "id", consultantId));

        String username = this.tokenAuthenticationService.getUsername(request);

        _saleEmployee.setRecordStatus(GlobalUtil.getInActiveStatus());
        _saleEmployee.setUpdatedBy(username);
        _saleEmployee.setUpdatedTime(GlobalUtil.getCurrentDateTime());

        this.saleEmployeeRepository.save(_saleEmployee);
    }

    public void deleteBysaleId(int saleId, HttpServletRequest request) {
        this.saleRepository.findById(saleId)
                .orElseThrow(() -> new ResourceNotFoundException("Sale", "id", saleId));
        String username = this.tokenAuthenticationService.getUsername(request);

        this.saleEmployeeRepository.deleteBySaleId(saleId);
    }

}
