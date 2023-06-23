package com.ziimme.websource.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ziimme.websource.models.Branch;
import com.ziimme.websource.services.BranchService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1.0")
public class BranchController {

    @Autowired
    private BranchService service;

    @RequestMapping(value = "branch", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<List<Branch>> getAllLogs() {
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "branch", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public ResponseEntity<Branch> createBranchs(@RequestBody Branch branchs, HttpServletRequest request) {
        try {
            return new ResponseEntity<>(this.service.create(branchs, request), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "branch/{id}", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
    public ResponseEntity<Branch> updateBranchs(@PathVariable("id") int branch_id,
            @RequestBody Branch branch,
            HttpServletRequest request) {
        return new ResponseEntity<>(this.service.update(branch_id, branch, request), HttpStatus.OK);
    }

    @RequestMapping(value = "branch/{id}", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8")
    public ResponseEntity<HttpStatus> deleteBranchs(@PathVariable("id") int branch_id,
            HttpServletRequest request) {
        try {
            this.service.delete(branch_id, request);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
