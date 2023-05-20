package com.ziimme.websource.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziimme.websource.exception.ResourceNotFoundException;
import com.ziimme.websource.models.Customer;
import com.ziimme.websource.repository.CustomerRepository;
import com.ziimme.websource.security.TokenAuthenticationService;
import com.ziimme.websource.utils.GlobalUtil;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TokenAuthenticationService tokenAuthenticationService;

    public List<Customer> getAll() {
        return this.customerRepository.findAll();
    }

    public Customer getById(int cus_id) {
        Customer customers = this.customerRepository.findById(cus_id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", cus_id));

        return customers;
    }

    public Customer create(Customer customers) {
        // String username = this.tokenAuthenticationService.getUsername(request);

        Customer _customers = new Customer();
        _customers.setCus_prefix(customers.getCus_prefix());
        _customers.setCus_full_name(customers.getCus_full_name());
        _customers.setCus_nick_name(customers.getCus_nick_name());
        _customers.setCus_birthday(customers.getCus_birthday());
        _customers.setCus_gender(customers.getCus_gender());
        _customers.setCus_occupation(customers.getCus_occupation());
        _customers.setCus_status(customers.getCus_status());
        _customers.setCus_telephone(customers.getCus_telephone());
        _customers.setCus_member(customers.getCus_member());
        _customers.setCus_salary(customers.getCus_salary());
        _customers.setCus_payment(customers.getCus_payment());
        _customers.setCus_house_number(customers.getCus_house_number());
        _customers.setCus_moo(customers.getCus_moo());
        _customers.setCus_soi(customers.getCus_soi());
        _customers.setCus_road(customers.getCus_road());
        _customers.setProvinceID(customers.getProvinceID());
        _customers.setDistrictID(customers.getDistrictID());
        _customers.setSub_districtID(customers.getSub_districtID());
        _customers.setPostcodeID(customers.getPostcodeID());
        _customers.setCongenital_disease(customers.getCongenital_disease());
        _customers.setDrug_allergy(customers.getDrug_allergy());
        _customers.setRecordStatus(GlobalUtil.getActiveStatus());
        // _customers.setCreatedBy(username);
        _customers.setCreatedTime(GlobalUtil.getCurrentDateTime());
        return this.customerRepository.save(_customers);
    }

    public Customer update(int cus_id, Customer customer, HttpServletRequest request) {
        Customer _customer = this.customerRepository.findById(cus_id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", cus_id));

        String username = this.tokenAuthenticationService.getUsername(request);

        _customer.setCus_prefix(customer.getCus_prefix());
        _customer.setCus_full_name(customer.getCus_full_name());
        _customer.setCus_nick_name(customer.getCus_nick_name());
        _customer.setCus_birthday(customer.getCus_birthday());
        _customer.setCus_gender(customer.getCus_gender());
        _customer.setCus_occupation(customer.getCus_occupation());
        _customer.setCus_status(customer.getCus_status());
        _customer.setCus_telephone(customer.getCus_telephone());
        _customer.setCus_member(customer.getCus_member());
        _customer.setCus_salary(customer.getCus_salary());
        _customer.setCus_payment(customer.getCus_payment());
        _customer.setCus_house_number(customer.getCus_house_number());
        _customer.setCus_moo(customer.getCus_moo());
        _customer.setCus_soi(customer.getCus_soi());
        _customer.setCus_road(customer.getCus_road());
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

    public void delete(int cus_id, HttpServletRequest request) {
        Customer _customer = this.customerRepository.findById(cus_id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", cus_id));

        String username = this.tokenAuthenticationService.getUsername(request);

        _customer.setRecordStatus(GlobalUtil.getInActiveStatus());
        _customer.setUpdatedBy(username);
        _customer.setUpdatedTime(GlobalUtil.getCurrentDateTime());

        this.customerRepository.save(_customer);
    }
}
