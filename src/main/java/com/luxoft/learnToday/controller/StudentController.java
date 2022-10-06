package com.luxoft.learnToday.controller;


import com.luxoft.learnToday.dto.StudentDto;
import com.luxoft.learnToday.entity.Course;
import com.luxoft.learnToday.entity.Student;
import com.luxoft.learnToday.exception.DataNotFoundException;
import com.luxoft.learnToday.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @PostMapping
    public ResponseEntity<Student> postStudent(@RequestBody StudentDto student) {
        Student savedStudent = studentService.postStudent(student);
        return new ResponseEntity<Student>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping("/getAllCourses")
    public ResponseEntity<List<Course>> getCourseSortedByDate() {
        List<Course> coursesSortedByDate = studentService.getCourseSortedByDate();
        return new ResponseEntity<List<Course>>(coursesSortedByDate, HttpStatus.OK);
    }

    @DeleteMapping("/{enrollmentId}")
    public ResponseEntity<Boolean> deleteStudentEnrollment(@PathVariable Integer enrollmentId) {
        Boolean isStudentEnrollmentDeleted = studentService.deleteStudentEnrollment(enrollmentId);
        return new ResponseEntity<Boolean>(isStudentEnrollmentDeleted, HttpStatus.OK);
    }
}
