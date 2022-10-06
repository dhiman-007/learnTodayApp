package com.luxoft.learnToday.service;

import com.luxoft.learnToday.dto.StudentDto;
import com.luxoft.learnToday.entity.Course;
import com.luxoft.learnToday.entity.Student;
import com.luxoft.learnToday.exception.DataNotFoundException;
import com.luxoft.learnToday.repository.CourseRepository;
import com.luxoft.learnToday.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Student postStudent(StudentDto student) {
        Course course = courseRepository.findById(student.getCourseId())
                .orElseThrow(() ->
                        new DataNotFoundException("Unable to find a Course with :" + student.getCourseId()));

        Student studentToSave = new Student();
        studentToSave.setStudentId(student.getStudentId());
        studentToSave.setCourse(course);
        studentToSave.setStudentName(student.getStudentName());
        studentRepository.save(studentToSave);

        return studentToSave;
    }

    @Override
    public Boolean deleteStudentEnrollment(Integer studentEnrollmentId) {

        try{
            Boolean isStudentExist  = studentRepository.existsById(studentEnrollmentId);
            if(isStudentExist){
                Student student = studentRepository.findById(studentEnrollmentId).get();
                studentRepository.delete(student);
                return true;
            }
            else{
                throw new DataNotFoundException("Student with enrollmentId : " + studentEnrollmentId + " doesn't exist");
            }
        }
        catch (DataNotFoundException e){
            e.setErrorMessage("Something went Wrong!!!!");
            throw e;
        }
    }


    @Override
    public List<Course> getCourseSortedByDate() {

        List<Course> courses = null;
        try{
            courses = courseRepository.findAll()
                    .stream()
                    .sorted((o1, o2) -> o1.getCourseStartDate().compareTo(o2.getCourseStartDate()))
                    .collect(Collectors.toList());
        }
        catch (DataNotFoundException e){
            e.setErrorMessage("Unable to fetch Courses, try later.");
            throw e;
        }

        return courses;
    }
}
