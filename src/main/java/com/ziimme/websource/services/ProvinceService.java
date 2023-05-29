package com.ziimme.websource.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ziimme.websource.exception.ResourceNotFoundException;
import com.ziimme.websource.json.res.ResponseJson;
import com.ziimme.websource.models.Districts;
import com.ziimme.websource.models.Province;
import com.ziimme.websource.models.SubDistricts;
import com.ziimme.websource.repository.DistrictsRepository;
import com.ziimme.websource.repository.ProvinceRepository;
import com.ziimme.websource.repository.SubDistrictsRepository;

@Service
public class ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private DistrictsRepository districtsRepository;

    @Autowired
    private SubDistrictsRepository subdistrictsRepository;


    public List<Province> getAll() {
        return this.provinceRepository.findAll();
    }

    public ResponseEntity<Object> findByIdProvince(int province_id) {
        ResponseJson responseJson = new ResponseJson();
        List<Province> UserList = this.provinceRepository.findById(province_id);
        responseJson.setData(UserList);
        return new ResponseEntity<>(responseJson, HttpStatus.OK);
    }

    public List<Districts> getAllDistricts() {
        return this.districtsRepository.findAll();
    }

    public List<SubDistricts> getAllSubDistricts() {
        return this.subdistrictsRepository.findAll();
    }

    // Get By Id Province
    public ResponseEntity<Object> findById(int province_id) {
        ResponseJson responseJson = new ResponseJson();
        List<Districts> UserList = this.districtsRepository.findById(province_id);
        responseJson.setData(UserList);
        return new ResponseEntity<>(responseJson, HttpStatus.OK);
    }

    // Get By Id SubDistricts
    public ResponseEntity<Object> fingByidDistrict(int districts_id) {
        ResponseJson responseJson = new ResponseJson();
        List<SubDistricts> SubList = this.subdistrictsRepository.findById(districts_id);
        responseJson.setData(SubList);
        return new ResponseEntity<>(responseJson, HttpStatus.OK);
    }

    // Get By Id SubDistricts
    public ResponseEntity<Object> FingByIdSub(int sub_districts_id) {
        ResponseJson responseJson = new ResponseJson();
        List<SubDistricts> SubList = this.subdistrictsRepository.findByIdSub(sub_districts_id);
        responseJson.setData(SubList);
        return new ResponseEntity<>(responseJson, HttpStatus.OK);
    }

}
