package com.luxoft.learnToday.controller;

import com.luxoft.learnToday.entity.Course;
import com.luxoft.learnToday.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class CourseController {

    private CourseServiceImpl courseService;

    @Autowired
    public CourseController(CourseServiceImpl courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/course")
    public ResponseEntity<Course> saveCourse(@RequestBody Course course) throws Exception {
        Course savedCourse = courseService.saveCourse(course);
        return new ResponseEntity<Course>(savedCourse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourse() throws Exception {
        List<Course> courses = courseService.getAllCourse();
        return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourseById(@PathVariable Integer courseId) {
        Course courseById = courseService.getCourseById(courseId);
        return new ResponseEntity<Course>(courseById, HttpStatus.OK);
    }
}
