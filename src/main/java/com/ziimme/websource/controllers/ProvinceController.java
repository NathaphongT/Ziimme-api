package com.ziimme.websource.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ziimme.websource.models.Districts;
import com.ziimme.websource.models.Province;
import com.ziimme.websource.models.SubDistricts;
import com.ziimme.websource.services.ProvinceService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/backend/api/v1.0")
public class ProvinceController {

    @Autowired
    ProvinceService service;

    @RequestMapping(value = "province", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<List<Province>> getAllProvince() {
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "province/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<Object> findByIdProvince(@PathVariable("id") int province_id) {
        return service.findByIdProvince(province_id);
    }

    @RequestMapping(value = "districts", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<List<Districts>> getAllDistricts() {
        return new ResponseEntity<>(this.service.getAllDistricts(), HttpStatus.OK);
    }

    @RequestMapping(value = "districts/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<Object> findById(@PathVariable("id") int province_id) {
        return service.findById(province_id);
    }

    @RequestMapping(value = "sub_districts", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<List<SubDistricts>> getAllSubDistricts() {
        return new ResponseEntity<>(this.service.getAllSubDistricts(), HttpStatus.OK);
    }

    @RequestMapping(value = "sub_districts/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<Object> fingByidDistrict(@PathVariable("id") int districts_id) {
        return service.fingByidDistrict(districts_id);
    }

    @RequestMapping(value = "sub/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<Object> FingByIdSub(@PathVariable("id") int sub_districts_id) {
        return service.FingByIdSub(sub_districts_id);
    }

}
