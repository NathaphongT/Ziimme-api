package com.ziimme.websource.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ziimme.websource.models.SaleCut;
import com.ziimme.websource.services.SaleCutService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1.0")
public class SaleCutController {
    @Autowired
    private SaleCutService service;

    @RequestMapping(value = "sale_cut", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<List<SaleCut>> getAllSale() {
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }
}
