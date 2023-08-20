package com.ziimme.websource.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ziimme.websource.exception.ResourceNotFoundException;
import com.ziimme.websource.models.Course;
import com.ziimme.websource.models.Customer;
import com.ziimme.websource.models.CustomerSpecification;
import com.ziimme.websource.models.UsersSpecification;
import com.ziimme.websource.repository.CustomerRepository;
import com.ziimme.websource.repository.UsersRepository;
import com.ziimme.websource.security.TokenAuthenticationService;
import com.ziimme.websource.utils.GlobalUtil;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private CustomerSpecification customerSpecification;
    private TokenAuthenticationService tokenAuthenticationService;

    @Autowired
    public void setWarehouseService(
            CustomerRepository customerRepository,
            CustomerSpecification customerSpecification,
            TokenAuthenticationService tokenAuthenticationService) {
        this.customerRepository = customerRepository;
        this.customerSpecification = customerSpecification;
        this.tokenAuthenticationService = tokenAuthenticationService;
    }

    public List<Customer> getAll() {
        return this.customerRepository.findAll();
    }

    public Page<Customer> search(String q, Pageable pageable) {
        return this.customerRepository.findAll(customerSpecification.searchByName(q), pageable);
    }

    public Customer getById(int cusId) {
        Customer customers = this.customerRepository.findById(cusId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", cusId));

        return customers;
    }

    public Customer create(Customer customer) {
        // String username = this.tokenAuthenticationService.getUsername(request);

        Customer _customer = new Customer();
        _customer.setCusPrefix(customer.getCusPrefix());
        _customer.setCusFullName(customer.getCusFullName());
        _customer.setCusNickName(customer.getCusNickName());
        _customer.setCusBirthday(customer.getCusBirthday());
        _customer.setCusGender(customer.getCusGender());
        _customer.setCusOccupation(customer.getCusOccupation());
        _customer.setCusStatus(customer.getCusStatus());
        _customer.setCusTelephone(customer.getCusTelephone());
        _customer.setCusMember(customer.getCusMember());
        _customer.setCusBranch(customer.getCusBranch());
        _customer.setCusSalary(customer.getCusSalary());
        _customer.setCusPayment(customer.getCusPayment());
        _customer.setCusHouseNumber(customer.getCusHouseNumber());
        _customer.setCusMoo(customer.getCusMoo());
        _customer.setCusSoi(customer.getCusSoi());
        _customer.setCusRoad(customer.getCusRoad());
        _customer.setProvinceID(customer.getProvinceID());
        _customer.setDistrictID(customer.getDistrictID());
        _customer.setSub_districtID(customer.getSub_districtID());
        _customer.setPostcodeID(customer.getPostcodeID());
        _customer.setCongenital_disease(customer.getCongenital_disease());
        _customer.setDrug_allergy(customer.getDrug_allergy());
        _customer.setRecordStatus(GlobalUtil.getActiveStatus());
        // _customer.setCreatedBy(username);
        _customer.setCreatedTime(GlobalUtil.getCurrentDateTime());
        return this.customerRepository.save(_customer);
    }

    public Customer update(int cusId, Customer customer, HttpServletRequest request) {
        Customer _customer = this.customerRepository.findById(cusId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", cusId));

        String username = this.tokenAuthenticationService.getUsername(request);

        _customer.setCusPrefix(customer.getCusPrefix());
        _customer.setCusFullName(customer.getCusFullName());
        _customer.setCusNickName(customer.getCusNickName());
        _customer.setCusBirthday(customer.getCusBirthday());
        _customer.setCusGender(customer.getCusGender());
        _customer.setCusOccupation(customer.getCusOccupation());
        _customer.setCusStatus(customer.getCusStatus());
        _customer.setCusTelephone(customer.getCusTelephone());
        _customer.setCusBranch(customer.getCusBranch());
        _customer.setCusMember(customer.getCusMember());
        _customer.setCusSalary(customer.getCusSalary());
        _customer.setCusPayment(customer.getCusPayment());
        _customer.setCusHouseNumber(customer.getCusHouseNumber());
        _customer.setCusMoo(customer.getCusMoo());
        _customer.setCusSoi(customer.getCusSoi());
        _customer.setCusRoad(customer.getCusRoad());
        _customer.setProvinceID(customer.getProvinceID());
        _customer.setDistrictID(customer.getDistrictID());
        _customer.setSub_districtID(customer.getSub_districtID());
        _customer.setPostcodeID(customer.getPostcodeID());
        _customer.setCongenital_disease(customer.getCongenital_disease());
        _customer.setDrug_allergy(customer.getDrug_allergy());
        _customer.setUpdatedBy(username);
        _customer.setUpdatedTime(GlobalUtil.getCurrentDateTime());

        _customer = this.customerRepository.save(_customer);

        return _customer;
    }

    public void delete(int cusId, HttpServletRequest request) {
        Customer _customer = this.customerRepository.findById(cusId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", cusId));

        String username = this.tokenAuthenticationService.getUsername(request);

        _customer.setRecordStatus(GlobalUtil.getInActiveStatus());
        _customer.setUpdatedBy(username);
        _customer.setUpdatedTime(GlobalUtil.getCurrentDateTime());

        this.customerRepository.save(_customer);
    }
}
