package com.ziimme.websource.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziimme.websource.exception.ResourceNotFoundException;
import com.ziimme.websource.models.Course;
import com.ziimme.websource.repository.CourseRepository;
import com.ziimme.websource.security.TokenAuthenticationService;
import com.ziimme.websource.utils.GlobalUtil;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TokenAuthenticationService tokenAuthenticationService;

    public List<Course> getAll() {
        return this.courseRepository.findAll();
    }

    public Course create(Course courses, HttpServletRequest request) {
        String username = this.tokenAuthenticationService.getUsername(request);

        Course _courses = new Course();
        _courses.setCourse_name_th(courses.getCourse_name_th());
        _courses.setCourse_name_eng(courses.getCourse_name_eng());
        _courses.setCourse_code(courses.getCourse_code());
        _courses.setCourse_detail(courses.getCourse_detail());
        _courses.setRecordStatus(GlobalUtil.getActiveStatus());
        _courses.setCreatedBy(username);
        _courses.setCreatedTime(GlobalUtil.getCurrentDateTime());
        return this.courseRepository.save(_courses);
    }

    public Course update(int course_id, Course course, HttpServletRequest request) {
        Course _course = this.courseRepository.findById(course_id)
                .orElseThrow(() -> new ResourceNotFoundException("Course", "id", course_id));

        String username = this.tokenAuthenticationService.getUsername(request);

        _course.setCourse_name_th(course.getCourse_name_th());
        _course.setCourse_name_eng(course.getCourse_name_eng());
        _course.setCourse_code(course.getCourse_code());
        _course.setCourse_detail(course.getCourse_detail());
        _course.setUpdatedBy(username);
        _course.setUpdatedTime(GlobalUtil.getCurrentDateTime());

        _course = this.courseRepository.save(_course);

        return _course;
    }

    public void delete(int course_id, HttpServletRequest request) {
        Course _course = this.courseRepository.findById(course_id)
                .orElseThrow(() -> new ResourceNotFoundException("Course", "id", course_id));

        String username = this.tokenAuthenticationService.getUsername(request);

        _course.setRecordStatus(GlobalUtil.getInActiveStatus());
        _course.setUpdatedBy(username);
        _course.setUpdatedTime(GlobalUtil.getCurrentDateTime());

        this.courseRepository.save(_course);
    }

}
