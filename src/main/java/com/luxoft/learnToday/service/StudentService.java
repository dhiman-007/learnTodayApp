package com.luxoft.learnToday.service;

import com.luxoft.learnToday.dto.StudentDto;
import com.luxoft.learnToday.entity.Course;
import com.luxoft.learnToday.entity.Student;

import java.util.List;

public interface StudentService {

    Student postStudent(StudentDto student);

    Boolean deleteStudentEnrollment(Integer studentEnrollmentId);

    List<Course> getCourseSortedByDate();

}
