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

import com.ziimme.websource.models.Position;
import com.ziimme.websource.services.PositionService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1.0")
public class PositionController {
    @Autowired
    private PositionService service;

    @RequestMapping(value = "position", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<List<Position>> getAllLogs() {
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "position", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public ResponseEntity<Position> createPositions(@RequestBody Position Positions, HttpServletRequest request) {
        try {
            return new ResponseEntity<>(this.service.create(Positions, request), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "position/{id}", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
    public ResponseEntity<Position> updatePositions(@PathVariable("id") int position_id,
            @RequestBody Position position,
            HttpServletRequest request) {
        return new ResponseEntity<>(this.service.update(position_id, position, request), HttpStatus.OK);
    }

    @RequestMapping(value = "position/{id}", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8")
    public ResponseEntity<HttpStatus> deletePositions(@PathVariable("id") int position_id,
            HttpServletRequest request) {
        try {
            this.service.delete(position_id, request);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
