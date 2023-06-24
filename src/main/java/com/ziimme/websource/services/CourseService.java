package com.ziimme.websource.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ziimme.websource.exception.ResourceNotFoundException;
import com.ziimme.websource.models.Course;
import com.ziimme.websource.models.CourseSpecification;

import com.ziimme.websource.repository.CourseRepository;
import com.ziimme.websource.security.TokenAuthenticationService;
import com.ziimme.websource.utils.GlobalUtil;

@Service
public class CourseService {

    private CourseRepository courseRepository;
    private CourseSpecification courseSpecification;
    private TokenAuthenticationService tokenAuthenticationService;

    @Autowired
    public void setWarehouseService(
            CourseRepository courseRepository,
            CourseSpecification courseSpecification,
            TokenAuthenticationService tokenAuthenticationService) {
        this.courseRepository = courseRepository;
        this.courseSpecification = courseSpecification;
        this.tokenAuthenticationService = tokenAuthenticationService;
    }

    public List<Course> getAll() {
        return this.courseRepository.findAll();
    }

    public Page<Course> search(String q, Pageable pageable) {
        return this.courseRepository.findAll(courseSpecification.searchByName(q), pageable);
    }

    public Course getById(int courseId) {
        Course course = this.courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Position", "id", courseId));

        return course;
    }

    public Course create(Course course, HttpServletRequest request) {
        String username = this.tokenAuthenticationService.getUsername(request);

        Course _course = new Course();
        _course.setCourseNameTh(course.getCourseNameTh());
        _course.setCourseNameEng(course.getCourseNameEng());
        _course.setCourseCode(course.getCourseCode());
        _course.setCourseDetail(course.getCourseDetail());
        _course.setRecordStatus(GlobalUtil.getActiveStatus());
        _course.setCreatedBy(username);
        _course.setCreatedTime(GlobalUtil.getCurrentDateTime());
        return this.courseRepository.save(_course);
    }

    public Course update(int courseId, Course course, HttpServletRequest request) {
        Course _course = this.courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course", "id", courseId));

        String username = this.tokenAuthenticationService.getUsername(request);

        _course.setCourseNameTh(course.getCourseNameTh());
        _course.setCourseNameEng(course.getCourseNameEng());
        _course.setCourseCode(course.getCourseCode());
        _course.setCourseDetail(course.getCourseDetail());
        _course.setUpdatedBy(username);
        _course.setUpdatedTime(GlobalUtil.getCurrentDateTime());

        _course = this.courseRepository.save(_course);

        return _course;
    }

    public void delete(int courseId, HttpServletRequest request) {
        Course _course = this.courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course", "id", courseId));

        String username = this.tokenAuthenticationService.getUsername(request);

        _course.setRecordStatus(GlobalUtil.getInActiveStatus());
        _course.setUpdatedBy(username);
        _course.setUpdatedTime(GlobalUtil.getCurrentDateTime());

        this.courseRepository.save(_course);
    }

}
