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
import com.ziimme.websource.services.PositionService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1.0")
public class PositionController {
    @Autowired
    private PositionService service;

    @RequestMapping(value = "positions", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<PageResponse> searchPositions(
            @RequestParam(required = false) String q,
            @RequestParam(defaultValue = "1", required = false) int page,
            @RequestParam(defaultValue = "10", required = false) int limit,
            @RequestParam(defaultValue = "createdTime", required = false) String sort,
            @RequestParam(defaultValue = "asc", required = false) String order) {
        try {
            List<Position> positions = new ArrayList<Position>();

            Sort.Direction direction = Sort.Direction.ASC;
            if (order.equalsIgnoreCase("desc")) {
                direction = Sort.Direction.DESC;
            }

            Pageable paging = PageRequest.of(page - 1, limit, direction, sort);

            Page<Position> positionPage = this.service.search(q, paging);
            positions = positionPage.getContent();

            PageResponse response = new PageResponse();
            response.setData(positions);
            response.setCurrentPage(positionPage.getNumber() + 1);
            response.setTotalItems(positionPage.getTotalElements());
            response.setTotalPages(positionPage.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println(ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "positions/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<Position> getPositionById(@PathVariable("id") int positionId) {
        return new ResponseEntity<>(this.service.getById(positionId), HttpStatus.OK);
    }

    @RequestMapping(value = "positions", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public ResponseEntity<Position> createPositions(@RequestBody Position Positions, HttpServletRequest request) {
        try {
            return new ResponseEntity<>(this.service.create(Positions, request), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "positions/{id}", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
    public ResponseEntity<Position> updatePositions(@PathVariable("id") int position_id,
            @RequestBody Position position,
            HttpServletRequest request) {
        return new ResponseEntity<>(this.service.update(position_id, position, request), HttpStatus.OK);
    }

    @RequestMapping(value = "positions/{id}", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8")
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
