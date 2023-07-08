package com.ziimme.websource.controllers;

import com.ziimme.websource.json.res.PageResponse;
import com.ziimme.websource.models.Branch;
import com.ziimme.websource.services.BranchService;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/backend/api/v1.0")
public class BranchController {

    @Autowired
    private BranchService service;

    @RequestMapping(value = "branchs", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<PageResponse> searchBranchs(
            @RequestParam(required = false) String q,
            @RequestParam(defaultValue = "1", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int limit,
            @RequestParam(defaultValue = "createdTime", required = false) String sort,
            @RequestParam(defaultValue = "asc", required = false) String order) {
        try {
            List<Branch> branchs = new ArrayList<Branch>();

            Sort.Direction direction = Sort.Direction.ASC;
            if (order.equalsIgnoreCase("desc")) {
                direction = Sort.Direction.DESC;
            }

            Pageable paging = PageRequest.of(page - 1, limit, direction, sort);

            Page<Branch> branchPage = this.service.search(q, paging);
            branchs = branchPage.getContent();

            PageResponse response = new PageResponse();
            response.setData(branchs);
            response.setCurrentPage(branchPage.getNumber() + 1);
            response.setTotalItems(branchPage.getTotalElements());
            response.setTotalPages(branchPage.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println(ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

   @RequestMapping(value = "branchs/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<Branch> getBranchById(@PathVariable("id") int branchId) {
        return new ResponseEntity<>(this.service.getById(branchId), HttpStatus.OK);
    }

    @RequestMapping(value = "branchs", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public ResponseEntity<Branch> createBranchs(@RequestBody Branch branchs, HttpServletRequest request) {
        try {
            return new ResponseEntity<>(this.service.create(branchs, request), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "branchs/{id}", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
    public ResponseEntity<Branch> updateBranchs(@PathVariable("id") int branch_id,
            @RequestBody Branch branch,
            HttpServletRequest request) {
        return new ResponseEntity<>(this.service.update(branch_id, branch, request), HttpStatus.OK);
    }

    @RequestMapping(value = "branchs/{id}", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8")
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
