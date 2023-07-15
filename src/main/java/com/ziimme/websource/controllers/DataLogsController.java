package com.ziimme.websource.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ziimme.websource.json.res.PageResponse;
import com.ziimme.websource.models.DataLogs;
import com.ziimme.websource.services.DataLogService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/backend/api/v1.0")
public class DataLogsController {
    @Autowired
    private DataLogService service;
    // @Autowired
    // private TokenAuthenticationService jwt;

    @RequestMapping(value = "/logs", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<PageResponse> searchLogs(
            @RequestParam(required = false) String q,
            @RequestParam(defaultValue = "1", required = false) int page,
            @RequestParam(defaultValue = "100", required = false) int limit,
            HttpServletRequest request) {
        try {
            List<DataLogs> dataLogs = new ArrayList<DataLogs>();
            Pageable paging = PageRequest.of(page - 1, limit);

            Page<DataLogs> dataLogsPage = this.service.search(q, paging);
            dataLogs = dataLogsPage.getContent();

            PageResponse response = new PageResponse();
            response.setData(dataLogs);
            response.setCurrentPage(dataLogsPage.getNumber() + 1);
            response.setTotalItems(dataLogsPage.getTotalElements());
            response.setTotalPages(dataLogsPage.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println(ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/logs", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public ResponseEntity<DataLogs> createLogs(@RequestBody DataLogs dataLogs, HttpServletRequest request) {
        try {
            return new ResponseEntity<>(this.service.create(dataLogs, request), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
