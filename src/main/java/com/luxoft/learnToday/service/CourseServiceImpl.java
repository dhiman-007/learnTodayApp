package com.luxoft.learnToday.service;

import com.luxoft.learnToday.entity.Course;
import com.luxoft.learnToday.exception.DataNotFoundException;
import com.luxoft.learnToday.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course saveCourse(Course course) throws DataNotFoundException {
        Course savedCourse = null;
        try {
           savedCourse = courseRepository.save(course);
        } catch (DataNotFoundException e) {
            e.setErrorMessage("Unable to save Course");
            throw e;
        }
        return savedCourse;
    }

    @Override
    public List<Course> getAllCourse() throws DataNotFoundException {
        List<Course> courses = null;
        try {
            courses = courseRepository.findAll();
        } catch (DataNotFoundException e) {
            e.setErrorMessage("Courses Not Found");
            throw e;
        }
        return courses;
    }

    @Override
    public Course getCourseById(Integer courseId) throws DataNotFoundException {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() ->
                        new DataNotFoundException(
                                "Course Not Found With Id : " + courseId));
        return course;
    }
}
