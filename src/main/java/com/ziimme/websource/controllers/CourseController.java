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

import com.ziimme.websource.models.Course;
import com.ziimme.websource.services.CourseService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1.0")
public class CourseController {
    @Autowired
    private CourseService service;

    @RequestMapping(value = "course", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<List<Course>> getAllLogs() {
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "course", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public ResponseEntity<Course> createCourses(@RequestBody Course courses, HttpServletRequest request) {
        try {
            return new ResponseEntity<>(this.service.create(courses, request), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "course/{id}", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
    public ResponseEntity<Course> updateCourses(@PathVariable("id") int course_id,
            @RequestBody Course Course,
            HttpServletRequest request) {
        return new ResponseEntity<>(this.service.update(course_id, Course, request), HttpStatus.OK);
    }

    @RequestMapping(value = "course/{id}", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8")
    public ResponseEntity<HttpStatus> deleteCourses(@PathVariable("id") int course_id,
            HttpServletRequest request) {
        try {
            this.service.delete(course_id, request);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
