package com.luxoft.learnToday.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer enrollmentId;
    private String studentName;
    private Integer studentId;

    @ManyToOne
    @JsonIgnore
    private Course course;

}
