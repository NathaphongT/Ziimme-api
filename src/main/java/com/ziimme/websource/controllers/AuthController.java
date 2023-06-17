package com.ziimme.websource.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ziimme.websource.json.LoginJson;
import com.ziimme.websource.json.res.ResponseJson;
// import com.ziimme.websource.security.TokenAuthenticationService;
import com.ziimme.websource.services.AuthService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1.0")
public class AuthController {
    @Autowired
    private AuthService service;
    // @Autowired
    // private TokenAuthenticationService jwt;

    @RequestMapping(value = "login", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public ResponseEntity<ResponseJson> login(@RequestBody LoginJson users) {
        try {
            return new ResponseEntity<>(this.service.login(users), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "authentication", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<Object> authentication(HttpServletRequest request) {
        return this.service.authentication(request);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<Object> logout(HttpServletRequest request) {
        return this.service.logout(request);
    }

}