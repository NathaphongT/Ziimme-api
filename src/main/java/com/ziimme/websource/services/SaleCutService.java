package com.ziimme.websource.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ziimme.websource.exception.ResourceNotFoundException;
import com.ziimme.websource.json.res.ResponseJson;
import com.ziimme.websource.models.Province;
import com.ziimme.websource.models.Sale;
import com.ziimme.websource.models.SaleCut;
import com.ziimme.websource.repository.SaleCutRepository;
import com.ziimme.websource.security.TokenAuthenticationService;
import com.ziimme.websource.utils.GlobalUtil;

@Service
public class SaleCutService {
    @Autowired
    private SaleCutRepository saleCutRepository;

    @Autowired
    private TokenAuthenticationService tokenAuthenticationService;

    public List<SaleCut> getAll() {
        return this.saleCutRepository.findAll();
    }

    public ResponseEntity<Object> getById(int saleProductId) {
        ResponseJson responseJson = new ResponseJson();
        List<SaleCut> UserList = this.saleCutRepository.findByIdCut(saleProductId);
        responseJson.setData(UserList);
        return new ResponseEntity<>(responseJson, HttpStatus.OK);
    }

    public SaleCut create(SaleCut saleCuts, HttpServletRequest request) {
        String username = this.tokenAuthenticationService.getUsername(request);

        SaleCut _saleCuts = new SaleCut();
        _saleCuts.setSaleCutCount(saleCuts.getSaleCutCount());
        _saleCuts.setSaleCount(saleCuts.getSaleCount());
        _saleCuts.setSaleCutCourse(saleCuts.getSaleCutCourse());
        _saleCuts.setSaleCutVitamin(saleCuts.getSaleCutVitamin());
        _saleCuts.setSaleCutMark(saleCuts.getSaleCutMark());
        _saleCuts.setSaleCutTherapist(saleCuts.getSaleCutTherapist());
        _saleCuts.setSaleCutDoctor(saleCuts.getSaleCutDoctor());
        _saleCuts.setSaleCutDetail(saleCuts.getSaleCutDetail());
        _saleCuts.setSaleCutDate(saleCuts.getSaleCutDate());
        _saleCuts.setSaleId(saleCuts.getSaleId());
        _saleCuts.setCourseId(saleCuts.getCourseId());
        _saleCuts.setSaleProductId(saleCuts.getSaleProductId());
        _saleCuts.setRecordStatus(GlobalUtil.getActiveStatus());
        _saleCuts.setCreatedBy(username);
        _saleCuts.setCreatedTime(GlobalUtil.getCurrentDateTime());
        return this.saleCutRepository.save(_saleCuts);
    }

    public SaleCut update(int saleCutId, SaleCut saleCuts, HttpServletRequest request) {
        SaleCut _saleCuts = this.saleCutRepository.findById(saleCutId)
                .orElseThrow(() -> new ResourceNotFoundException("Sale", "id", saleCutId));

        String username = this.tokenAuthenticationService.getUsername(request);

        _saleCuts.setSaleCutCount(saleCuts.getSaleCutCount());
        _saleCuts.setSaleCount(saleCuts.getSaleCount());
        _saleCuts.setSaleCutCourse(saleCuts.getSaleCutCourse());
        _saleCuts.setSaleCutVitamin(saleCuts.getSaleCutVitamin());
        _saleCuts.setSaleCutMark(saleCuts.getSaleCutMark());
        _saleCuts.setSaleCutTherapist(saleCuts.getSaleCutTherapist());
        _saleCuts.setSaleCutDoctor(saleCuts.getSaleCutDoctor());
        _saleCuts.setSaleCutDetail(saleCuts.getSaleCutDetail());
        _saleCuts.setSaleCutDate(saleCuts.getSaleCutDate());
        _saleCuts.setSaleId(saleCuts.getSaleId());
        _saleCuts.setCourseId(saleCuts.getCourseId());
        _saleCuts.setSaleProductId(saleCuts.getSaleProductId());
        _saleCuts.setRecordStatus(GlobalUtil.getActiveStatus());
        _saleCuts.setUpdatedBy(username);
        _saleCuts.setUpdatedTime(GlobalUtil.getCurrentDateTime());

        _saleCuts = this.saleCutRepository.save(_saleCuts);

        return _saleCuts;
    }
}
