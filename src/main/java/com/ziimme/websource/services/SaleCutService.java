package com.ziimme.websource.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public SaleCut create(SaleCut saleCuts, HttpServletRequest request) {
        String username = this.tokenAuthenticationService.getUsername(request);

        SaleCut _SaleCuts = new SaleCut();
        _SaleCuts.setSale_cut_product(saleCuts.getSale_cut_product());
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
        _SaleCuts.setSale_number(saleCuts.getSale_number());
        _SaleCuts.setSele_cut_date_service(saleCuts.getSele_cut_date_service());
        _SaleCuts.setRecordStatus(GlobalUtil.getActiveStatus());
        _SaleCuts.setCreatedBy(username);
        _SaleCuts.setCreatedTime(GlobalUtil.getCurrentDateTime());
        return this.saleCutRepository.save(_SaleCuts);
    }
}
