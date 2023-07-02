package com.ziimme.websource.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ziimme.websource.json.res.PageResponse;
import com.ziimme.websource.models.Position;
import com.ziimme.websource.models.Users;
import com.ziimme.websource.services.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1.0")
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping(value = "users", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<PageResponse> Users(
            @RequestParam(required = false) String q,
            @RequestParam(defaultValue = "1", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int limit,
            @RequestParam(defaultValue = "createdTime", required = false) String sort,
            @RequestParam(defaultValue = "asc", required = false) String order) {
        try {
            List<Users> users = new ArrayList<Users>();

            Sort.Direction direction = Sort.Direction.ASC;
            if (order.equalsIgnoreCase("desc")) {
                direction = Sort.Direction.DESC;
            }

            Pageable paging = PageRequest.of(page - 1, limit, direction, sort);

            Page<Users> userPage = this.service.search(q, paging);
            users = userPage.getContent();

            PageResponse response = new PageResponse();
            response.setData(users);
            response.setCurrentPage(userPage.getNumber() + 1);
            response.setTotalItems(userPage.getTotalElements());
            response.setTotalPages(userPage.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println(ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "users/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<Users> getUsersById(@PathVariable("id") int userId) {
        return new ResponseEntity<>(this.service.getById(userId), HttpStatus.OK);
    }

    @RequestMapping(value = "users", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public ResponseEntity<Users> createUsers(@RequestBody Users users, HttpServletRequest request) {
        try {
            return new ResponseEntity<>(this.service.create(users, request), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "users/{id}", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
    public ResponseEntity<Users> updateUsers(@PathVariable("id") int userId, @RequestBody Users users,
            HttpServletRequest request) {
        return new ResponseEntity<>(this.service.update(userId, users, request), HttpStatus.OK);
    }

    @RequestMapping(value = "users/{id}", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8")
    public ResponseEntity<HttpStatus> deleteUsers(@PathVariable("id") int userId, HttpServletRequest request) {
        try {
            this.service.delete(userId, request);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
