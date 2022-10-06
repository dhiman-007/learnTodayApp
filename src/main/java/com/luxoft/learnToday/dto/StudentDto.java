package com.luxoft.learnToday.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luxoft.learnToday.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
public class StudentDto {

    private String studentName;
    private Integer studentId;
    private Integer courseId;

}
