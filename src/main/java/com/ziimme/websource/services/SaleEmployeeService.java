package com.ziimme.websource.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ziimme.websource.exception.ResourceNotFoundException;
import com.ziimme.websource.models.Sale;
import com.ziimme.websource.models.SaleEmployee;
import com.ziimme.websource.models.Users;
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

    public List<SaleEmployee> getByWarehouseId(int saleId) {
        this.saleRepository.findById(saleId)
                .orElseThrow(() -> new ResourceNotFoundException("saleId", "id",
                        saleId));

        List<SaleEmployee> warehouseFarmCategories = this.saleEmployeeRepository
                .findByIdSale(saleId);

        return warehouseFarmCategories;
    }

    public List<SaleEmployee> getByWarehouseIdEmp(int empId) {
        this.saleRepository.findById(empId)
                .orElseThrow(() -> new ResourceNotFoundException("empId", "id",
                        empId));

        List<SaleEmployee> warehouseFarmCategories = this.saleEmployeeRepository
                .findByIdEmp(empId);

        return warehouseFarmCategories;
    }

    public List<SaleEmployee> getByWarehouseIdCus(int cusId) {
        this.saleRepository.findById(cusId)
                .orElseThrow(() -> new ResourceNotFoundException("cusId", "id",
                        cusId));

        List<SaleEmployee> warehouseFarmCategories = this.saleEmployeeRepository
                .findByIdCus(cusId);

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
        List<SaleEmployee> _warehouseFarmCategories = this.saleEmployeeRepository.saveAll(_SaleEmployee);

        return _warehouseFarmCategories;
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
        List<SaleEmployee> _warehouseFarmCategories = this.saleEmployeeRepository.saveAll(_SaleEmployee);

        return _warehouseFarmCategories;
    }

    // public void delete(int consultantId, HttpServletRequest request) {
    // SaleEmployee _warehouseFarmCategory =
    // this.saleEmployeeRepository.findById(consultantId)
    // .orElseThrow(() -> new ResourceNotFoundException("SaleEmpId", "id",
    // consultantId));

    // String username = this.tokenAuthenticationService.getUsername(request);

    // _warehouseFarmCategory.setRecordStatus(GlobalUtil.getInActiveStatus());
    // _warehouseFarmCategory.setUpdatedBy(username);
    // _warehouseFarmCategory.setUpdatedTime(GlobalUtil.getCurrentDateTime());

    // this.saleEmployeeRepository.save(_warehouseFarmCategory);
    // }

    // public void deleteBySaleId(int saleId, HttpServletRequest request) {
    // this.saleRepository.findById(saleId)
    // .orElseThrow(() -> new ResourceNotFoundException("Warehouse", "id",
    // saleId));
    // String username = this.tokenAuthenticationService.getUsername(request);

    // this.saleEmployeeRepository.deleteBySaleId(saleId);
    // }

}
