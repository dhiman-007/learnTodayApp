package com.luxoft.learnToday.service;

import com.luxoft.learnToday.entity.Course;

import java.util.List;

public interface CourseService {

    Course saveCourse(Course course) throws Exception;
    List<Course> getAllCourse() throws Exception;
    Course getCourseById(Integer courseId);
}
