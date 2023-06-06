package com.ziimme.websource.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ziimme.websource.exception.ResourceNotFoundException;
import com.ziimme.websource.json.res.ResponseJson;
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

    public ResponseEntity<Object> findByIdSaleCut(int sale_id) {
        ResponseJson responseJson = new ResponseJson();
        List<SaleCut> UserList = this.saleCutRepository.findByIdSaleCut(sale_id);
        responseJson.setData(UserList);
        return new ResponseEntity<>(UserList, HttpStatus.OK);
    }
    
    public ResponseEntity<Object> findIdSaleCutOrder(int sale_id) {
        ResponseJson responseJson = new ResponseJson();
        List<SaleCut> UserList = this.saleCutRepository.findIdSaleCutOrder(sale_id);
        responseJson.setData(UserList);
        return new ResponseEntity<>(UserList, HttpStatus.OK);
    }

    public SaleCut create(SaleCut saleCuts, HttpServletRequest request) {
        String username = this.tokenAuthenticationService.getUsername(request);

        SaleCut _SaleCuts = new SaleCut();
        _SaleCuts.setSale_cut_count(saleCuts.getSale_cut_count());
        _SaleCuts.setSale_cut_vitamin(saleCuts.getSale_cut_vitamin());
        _SaleCuts.setSale_cut_mark(saleCuts.getSale_cut_mark());
        _SaleCuts.setSale_cut_therapist(saleCuts.getSale_cut_therapist());
        _SaleCuts.setSale_cut_doctor(saleCuts.getSale_cut_doctor());
        _SaleCuts.setSale_cut_detail(saleCuts.getSale_cut_detail());
        _SaleCuts.setSale_cut_pay_balance(saleCuts.getSale_cut_pay_balance());
        _SaleCuts.setSale_cut_pay(saleCuts.getSale_cut_pay());
        _SaleCuts.setSale_cut_overdue(saleCuts.getSale_cut_overdue());
        _SaleCuts.setSale_id(saleCuts.getSale_id());
        _SaleCuts.setRecordStatus(GlobalUtil.getActiveStatus());
        _SaleCuts.setCreatedBy(username);
        _SaleCuts.setCreatedTime(GlobalUtil.getCurrentDateTime());
        return this.saleCutRepository.save(_SaleCuts);
    }

    public SaleCut update(int sale_cut_id, SaleCut saleCut, HttpServletRequest request) {
        SaleCut _salesCut = this.saleCutRepository.findById(sale_cut_id)
                .orElseThrow(() -> new ResourceNotFoundException("Sale", "id", sale_cut_id));

        String username = this.tokenAuthenticationService.getUsername(request);

        _salesCut.setSale_cut_count(saleCut.getSale_cut_count());
        _salesCut.setSale_cut_vitamin(saleCut.getSale_cut_vitamin());
        _salesCut.setSale_cut_mark(saleCut.getSale_cut_mark());
        _salesCut.setSale_cut_therapist(saleCut.getSale_cut_therapist());
        _salesCut.setSale_cut_doctor(saleCut.getSale_cut_doctor());
        _salesCut.setSale_cut_detail(saleCut.getSale_cut_detail());
        _salesCut.setSale_cut_pay_balance(saleCut.getSale_cut_pay_balance());
        _salesCut.setSale_cut_pay(saleCut.getSale_cut_pay());
        _salesCut.setSale_cut_overdue(saleCut.getSale_cut_overdue());
        _salesCut.setSale_id(saleCut.getSale_id());
        _salesCut.setRecordStatus(GlobalUtil.getActiveStatus());
        _salesCut.setUpdatedBy(username);
        _salesCut.setUpdatedTime(GlobalUtil.getCurrentDateTime());

        _salesCut = this.saleCutRepository.save(_salesCut);

        return _salesCut;
    }
}
