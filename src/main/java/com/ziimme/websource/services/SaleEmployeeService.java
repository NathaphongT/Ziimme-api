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

    public List<SaleEmployee> getByWarehouseId(int sale_id) {
        this.saleRepository.findById(sale_id)
                .orElseThrow(() -> new ResourceNotFoundException("sale_id", "id",
                        sale_id));

        List<SaleEmployee> warehouseFarmCategories = this.saleEmployeeRepository
                .findByIdSale(sale_id);

        return warehouseFarmCategories;
    }

    // public List<SaleEmployee> getByemp(int emp_id) {
    // List<SaleEmployee> warehouseFarmCategories = this.saleEmployeeRepository
    // .findById(emp_id);

    // return warehouseFarmCategories;
    // }

    public List<SaleEmployee> create(int sale_id, List<SaleEmployee> SaleEmployee, HttpServletRequest request) {
        this.saleRepository.findById(sale_id)
                .orElseThrow(() -> new ResourceNotFoundException("SaleID", "id", sale_id));

        String username = this.tokenAuthenticationService.getUsername(request);

        List<SaleEmployee> _SaleEmployee = new ArrayList<SaleEmployee>();
        for (SaleEmployee SaleEmployees : SaleEmployee) {
            SaleEmployee SaleEmps = new SaleEmployee();
            SaleEmps.setemp_id(SaleEmployees.getemp_id());
            SaleEmps.setRecordStatus(GlobalUtil.getActiveStatus());
            SaleEmps.setCreatedBy(username);
            SaleEmps.setCreatedTime(GlobalUtil.getCurrentDateTime());
            SaleEmps.setsale_id(sale_id);

            _SaleEmployee.add(SaleEmps);
        }
        List<SaleEmployee> _warehouseFarmCategories = this.saleEmployeeRepository.saveAll(_SaleEmployee);

        return _warehouseFarmCategories;
    }

    public List<SaleEmployee> update(int sale_id, List<SaleEmployee> SaleEmployee, HttpServletRequest request) {
        this.saleRepository.findById(sale_id)
                .orElseThrow(() -> new ResourceNotFoundException("SaleID", "id", sale_id));

        String username = this.tokenAuthenticationService.getUsername(request);

        List<SaleEmployee> _SaleEmployee = new ArrayList<SaleEmployee>();
        for (SaleEmployee SaleEmployees : SaleEmployee) {
            SaleEmployee SaleEmps = new SaleEmployee();
            SaleEmps.setemp_id(SaleEmployees.getemp_id());
            SaleEmps.setRecordStatus(GlobalUtil.getActiveStatus());
            SaleEmps.setUpdatedBy(username);
            SaleEmps.setUpdatedTime(GlobalUtil.getCurrentDateTime());
            SaleEmps.setsale_id(sale_id);

            _SaleEmployee.add(SaleEmps);
        }
        List<SaleEmployee> _warehouseFarmCategories = this.saleEmployeeRepository.saveAll(_SaleEmployee);

        return _warehouseFarmCategories;
    }

    // public void delete(int consultant_id, HttpServletRequest request) {
    // SaleEmployee _warehouseFarmCategory =
    // this.saleEmployeeRepository.findById(consultant_id)
    // .orElseThrow(() -> new ResourceNotFoundException("SaleEmpId", "id",
    // consultant_id));

    // String username = this.tokenAuthenticationService.getUsername(request);

    // _warehouseFarmCategory.setRecordStatus(GlobalUtil.getInActiveStatus());
    // _warehouseFarmCategory.setUpdatedBy(username);
    // _warehouseFarmCategory.setUpdatedTime(GlobalUtil.getCurrentDateTime());

    // this.saleEmployeeRepository.save(_warehouseFarmCategory);
    // }

    // public void deleteBySaleId(int sale_id, HttpServletRequest request) {
    // this.saleRepository.findById(sale_id)
    // .orElseThrow(() -> new ResourceNotFoundException("Warehouse", "id",
    // sale_id));
    // String username = this.tokenAuthenticationService.getUsername(request);

    // this.saleEmployeeRepository.deleteBySaleId(sale_id);
    // }

}
